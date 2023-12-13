package com.surajnarayanraut.mlm.service;

import com.surajnarayanraut.mlm.entity.Commission;
import com.surajnarayanraut.mlm.entity.Referral;
import com.surajnarayanraut.mlm.entity.User;
import com.surajnarayanraut.mlm.exception.ValidationException;
import com.surajnarayanraut.mlm.repository.CommissionRepo;
import com.surajnarayanraut.mlm.repository.ReferralRepo;
import com.surajnarayanraut.mlm.repository.UserRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ReferralService {
    private static final int MAX_LEVEL = 4;

    final ReferralRepo referralRepo;
    final UserRepo userRepo;
    final CommissionRepo commissionRepo;
    final CommissionService commissionService;

    public ReferralService(ReferralRepo referralRepo, UserRepo userRepo, CommissionRepo commissionRepo, CommissionService commissionService) {
        this.referralRepo = referralRepo;
        this.userRepo = userRepo;
        this.commissionRepo = commissionRepo;
        this.commissionService = commissionService;
    }


    public User findUserById(Long id, String msg) {
        return userRepo.findById(id).orElseThrow(() -> new ValidationException(msg));
    }

    public User findUserById(Long id) {
        return findUserById(id, "user not found");
    }

    public Optional<String> referalAlreadyExists(User userReferredTo) {
        if (referralRepo.referalAlreadyExists(userReferredTo))
            return Optional.of("User has been already referred");
        return Optional.empty();
    }

    @Transactional
    public void addReferral(Long referBy, Long referTo) {
        User userReferredTo = findUserById(referTo);

        User userRefereedBy = null;
        if (referBy != -1)
            userRefereedBy = findUserById(referBy);
        referalAlreadyExists(userReferredTo).ifPresent((msg) ->
        {
            throw new ValidationException(msg);
        });
        int level = 1;

        Referral referral = new Referral();
        referral.setReferTo(userReferredTo);
        referral.setReferBy(userRefereedBy);
        referralRepo.save(referral);

        while (level < MAX_LEVEL) {
            if (userRefereedBy == null) break;
            Commission commission = new Commission();
            commission.setReferBy(userRefereedBy);
            commission.setReferTo(userReferredTo);
            commission.setLevel(level);
            commission.setPercentage(commissionService.commissionPercentage.get(level));
            commissionRepo.save(commission);

            level++;
            userRefereedBy = referralRepo.findRefferedBy(userRefereedBy.getId()).orElse(null);
        }
    }
}

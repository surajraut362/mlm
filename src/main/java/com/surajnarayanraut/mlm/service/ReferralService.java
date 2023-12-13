package com.surajnarayanraut.mlm.service;

import com.surajnarayanraut.mlm.repository.ReferralRepo;
import org.springframework.stereotype.Service;

@Service
public class ReferralService {

    final ReferralRepo referralRepo;

    public ReferralService(ReferralRepo referralRepo) {
        this.referralRepo = referralRepo;
    }

    public void addReferral(Long referBy, Long referTo) {

    }
}

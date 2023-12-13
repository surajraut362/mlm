package com.surajnarayanraut.mlm.service;

import com.surajnarayanraut.mlm.dto.UserRegDto;
import com.surajnarayanraut.mlm.entity.User;
import com.surajnarayanraut.mlm.exception.ValidationException;
import com.surajnarayanraut.mlm.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService {
    final ModelMapper modelMapper;

    final UserRepo userRepo;
    final  ReferralService referralService;

    public UserService(ModelMapper modelMapper, UserRepo userRepo,
                       ReferralService referralService) {
        this.modelMapper = modelMapper;
        this.userRepo = userRepo;
        this.referralService = referralService;
    }


    @Transactional
    public User register(UserRegDto dto,Long referredBy) {
        getValidationError(dto).ifPresent((msg) -> {
            throw new ValidationException(msg);
        });
        if(referredBy!=-1)
        userRepo.findById(referredBy).orElseThrow(()->new ValidationException("Referre Doesn't Exist"));
        User user=modelMapper.map(dto, User.class);
        userRepo.saveAndFlush(user);
        referralService.addReferral(referredBy,user.getId());
        return user;

    }
    private Optional<String> getValidationError(UserRegDto dto) {
        // check user exists by email
        if(userRepo.existsByEmail(dto.getEmail()))
            return Optional.of("email exists");
        return Optional.empty();
    }




}
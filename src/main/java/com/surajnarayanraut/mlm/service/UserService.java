package com.surajnarayanraut.mlm.service;

import com.surajnarayanraut.mlm.dto.UserRegDto;
import com.surajnarayanraut.mlm.entity.User;
import com.surajnarayanraut.mlm.repository.CommissionRepo;
import com.surajnarayanraut.mlm.repository.RefferalRepo;
import com.surajnarayanraut.mlm.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private static final int MAX_LEVEL = 4;
    final
    ModelMapper modelMapper;

    final UserRepo userRepo;




    public UserService(ModelMapper modelMapper, UserRepo userRepo, CommissionService commisionService,
                       CommissionRepo commissionRepo) {
        this.modelMapper = modelMapper;
        this.userRepo = userRepo;
    }



    public void register(UserRegDto dto) {

    }

    private Optional<String> getValidationError(UserRegDto dto) {
       return null;
    }



}
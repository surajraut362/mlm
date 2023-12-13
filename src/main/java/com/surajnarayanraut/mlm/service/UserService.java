package com.surajnarayanraut.mlm.service;

import com.surajnarayanraut.mlm.dto.UserRegDto;
import com.surajnarayanraut.mlm.entity.User;
import com.surajnarayanraut.mlm.exception.ValidationException;
import com.surajnarayanraut.mlm.repository.CommissionRepo;
import com.surajnarayanraut.mlm.repository.UserRepo;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private static final int MAX_LEVEL = 4;
    final ModelMapper modelMapper;

    final UserRepo userRepo;


    public UserService(ModelMapper modelMapper, UserRepo userRepo
                       ) {
        this.modelMapper = modelMapper;
        this.userRepo = userRepo;
    }

    public User findUserById(Long id , String msg) {
        return userRepo.findById(id).orElseThrow(() -> new ValidationException(msg));
    }
    public User findUserById(Long id) {
        return findUserById(id, "user not found");
    }
    public User register(UserRegDto dto) {
        getValidationError(dto).ifPresent((msg) -> {
            throw new ValidationException(msg);
        });
        User user=modelMapper.map(dto, User.class);
        return userRepo.save(user);

    }
    private Optional<String> getValidationError(UserRegDto dto) {
        // check user exists by email
        if(userRepo.existsByEmail(dto.getEmail()))
            return Optional.of("email exists");
        return Optional.empty();
    }




}
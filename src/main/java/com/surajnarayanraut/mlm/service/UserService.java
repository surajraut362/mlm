package com.surajnarayanraut.mlm.service;

import com.surajnarayanraut.mlm.dto.UserRegDto;
import com.surajnarayanraut.mlm.entity.User;
import com.surajnarayanraut.mlm.exception.ValidationException;
import com.surajnarayanraut.mlm.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService {
    final AuthenticationManager authenticationManager;
    final ModelMapper modelMapper;

    final UserRepo userRepo;
    final PasswordEncoder passwordEncoder;
    final  ReferralService referralService;

    public UserService(AuthenticationManager authenticationManager, ModelMapper modelMapper, UserRepo userRepo,
                       PasswordEncoder passwordEncoder, ReferralService referralService) {
        this.authenticationManager = authenticationManager;
        this.modelMapper = modelMapper;
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
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
        user.setPassword(passwordEncoder.encode(user.getPassword()));

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


    public String authenticate(UserRegDto dto) {
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(),dto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "User Logged In Successfully";
    }
}
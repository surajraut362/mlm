package com.surajnarayanraut.mlm.controller;

import com.surajnarayanraut.mlm.dto.UserRegDto;
import com.surajnarayanraut.mlm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/users")
@RestController
public class UserController {
    final UserService userService;
    Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    void register(@Validated @RequestBody UserRegDto dto, @RequestParam(value = "referredBy") Long referredBy) {
        logger.info("Registering user");
        userService.register(dto, referredBy);
        logger.info("Registration Done");
    }

    @PostMapping("/login")
    void login(@Validated @RequestBody UserRegDto dto) {
        logger.info("Authenticating user");
        userService.authenticate(dto);
        logger.info("Authentication Successfull");
    }


}

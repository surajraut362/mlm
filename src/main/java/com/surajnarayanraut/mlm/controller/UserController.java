package com.surajnarayanraut.mlm.controller;

import com.surajnarayanraut.mlm.dto.UserRegDto;
import com.surajnarayanraut.mlm.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/users")
@RestController
public class UserController {

    final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/register")
    void register(@Validated @RequestBody UserRegDto dto,@RequestParam(value = "referredBy") Long referredBy) {
        userService.register(dto,referredBy);
    }


}

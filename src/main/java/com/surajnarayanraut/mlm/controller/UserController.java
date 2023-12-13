package com.surajnarayanraut.mlm.controller;

import com.surajnarayanraut.mlm.dto.UserRegDto;
import com.surajnarayanraut.mlm.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/users")
@RestController
public class UserController {

    final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/register")
    void register(@Validated @RequestBody UserRegDto dto) {
        userService.register(dto);
    }


}

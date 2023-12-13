package com.surajnarayanraut.mlm.controller;

import com.surajnarayanraut.mlm.dto.UserRegDto;
import com.surajnarayanraut.mlm.entity.Commission;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/users")
@RestController
public class UserController {





    @PostMapping("/register")
    void register(@RequestBody UserRegDto dto){

    }




}

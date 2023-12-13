package com.surajnarayanraut.mlm.controller;

import com.surajnarayanraut.mlm.entity.Commission;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/commissions")
@RestController
public class CommissionController {
    @GetMapping("/{userId}")
    List<Commission> listCommissions(@PathVariable Long userId) {
        return null;
    }

}

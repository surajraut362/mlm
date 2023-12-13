package com.surajnarayanraut.mlm.controller;

import com.surajnarayanraut.mlm.dto.CommissionDto;
import com.surajnarayanraut.mlm.entity.Commission;
import com.surajnarayanraut.mlm.service.CommissionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/commissions")
@RestController
public class CommissionController {
    final CommissionService commissionService;

    public CommissionController(CommissionService commissionService) {
        this.commissionService = commissionService;
    }

    @GetMapping("/{userId}")
    List<CommissionDto> listCommissions(@PathVariable Long userId) {

        return  commissionService.listCommissions(userId);

    }

}

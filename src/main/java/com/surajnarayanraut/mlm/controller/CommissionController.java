package com.surajnarayanraut.mlm.controller;

import com.surajnarayanraut.mlm.dto.CommissionDto;
import com.surajnarayanraut.mlm.service.CommissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/commissions")
@RestController
public class CommissionController {
    final CommissionService commissionService;
    Logger logger = LoggerFactory.getLogger(CommissionController.class);

    public CommissionController(CommissionService commissionService) {
        this.commissionService = commissionService;
    }

    @GetMapping("/{userId}")
    List<CommissionDto> listCommissions(@PathVariable Long userId) {
        logger.info("List of Commissions for a specific user");
        return commissionService.listCommissions(userId);

    }

}

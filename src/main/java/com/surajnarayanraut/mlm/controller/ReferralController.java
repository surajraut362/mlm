package com.surajnarayanraut.mlm.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/referral")
@RestController
public class ReferralController {
    @PostMapping("/{referBy}/{referTo}")
    void addReferral(@PathVariable Long referBy, @PathVariable Long referTo) {

    }
}

package com.surajnarayanraut.mlm.service;

import com.surajnarayanraut.mlm.repository.RefferalRepo;
import org.springframework.stereotype.Service;

@Service
public class RefferalService {

    final RefferalRepo refferalRepo;

    public RefferalService(RefferalRepo refferalRepo) {
        this.refferalRepo = refferalRepo;
    }

    public void addReferral(Long referBy, Long referTo) {

    }
}

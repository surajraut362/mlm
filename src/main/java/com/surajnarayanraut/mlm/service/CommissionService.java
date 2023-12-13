package com.surajnarayanraut.mlm.service;

import com.surajnarayanraut.mlm.dto.CommissionDto;
import com.surajnarayanraut.mlm.repository.CommissionRepo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommissionService {

    final CommissionRepo commissionRepo;

    Map<Integer, Float> commissionPercentage = new HashMap<>() {{
        put(1, 10f);
        put(2, 5f);
        put(3, 1f);
    }};

    public CommissionService(CommissionRepo commissionRepo) {
        this.commissionRepo = commissionRepo;
    }

    public List<CommissionDto> listCommissions(Long userId) {
        return commissionRepo.list(userId);

    }
}
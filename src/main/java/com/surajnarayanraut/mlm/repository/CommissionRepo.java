package com.surajnarayanraut.mlm.repository;


import com.surajnarayanraut.mlm.entity.Commission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CommissionRepo extends JpaRepository<Commission,Long> {
    List<Commission> list(Long userId);
}

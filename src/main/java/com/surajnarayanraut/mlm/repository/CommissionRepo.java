package com.surajnarayanraut.mlm.repository;


import com.surajnarayanraut.mlm.dto.CommissionDto;
import com.surajnarayanraut.mlm.entity.Commission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CommissionRepo extends JpaRepository<Commission, Long> {
    @Query("select new com.surajnarayanraut.mlm.dto.CommissionDto(com.percentage, referTo.name, referTo.id) from Commission com JOIN com.referBy referBy JOIN com.referTo referTo where referBy.id = :userId")

    List<CommissionDto> list(Long userId);
}

package com.surajnarayanraut.mlm.repository;

import com.surajnarayanraut.mlm.entity.Referral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefferalRepo extends JpaRepository<Referral,Long> {
}

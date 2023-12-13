package com.surajnarayanraut.mlm.repository;

import com.surajnarayanraut.mlm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}

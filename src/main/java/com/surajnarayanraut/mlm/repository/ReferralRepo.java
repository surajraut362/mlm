package com.surajnarayanraut.mlm.repository;

import com.surajnarayanraut.mlm.entity.Referral;
import com.surajnarayanraut.mlm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReferralRepo extends JpaRepository<Referral,Long> {

    @Query("select ref.referBy from Referral ref where ref.referTo.id = :user")
    Optional<User> findRefferedBy(Long user);

    @Query("select CASE WHEN COUNT(ref) > 0 THEN true ELSE false END from Referral ref where ref.referTo = :user")
    Boolean referalAlreadyExists(User user);
}

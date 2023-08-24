package com.practice.springpractice.repository;

import com.practice.springpractice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Modifying
    @Query("UPDATE User u SET u.successAttempts = u.successAttempts + 1 WHERE u.id = ?1")
    void incrementSuccessAttempts(Long id);

    @Modifying
    @Query("UPDATE User u SET u.failedAttempts = u.failedAttempts + 1 WHERE u.id = ?1")
    void incrementFailedAttempts(Long id);
}

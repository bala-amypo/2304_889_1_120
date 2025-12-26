package com.example.demo.repository;

import com.example.demo.entity.UserAccount;
import java.util.Optional;

public interface UserAccountRepository {
    boolean existsByEmail(String email);
    Optional<UserAccount> findByEmail(String email);
    UserAccount save(UserAccount user);
}
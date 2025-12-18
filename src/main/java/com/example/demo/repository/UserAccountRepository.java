package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserAccount;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount,Long>{

}
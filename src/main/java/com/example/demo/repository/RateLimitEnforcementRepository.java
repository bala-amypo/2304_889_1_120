package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.RateLimitEnforcement;

@Repository
public interface RateLimitEnforcementRepository extends JpaRepository<RateLimitEnforcement,Long>{

}

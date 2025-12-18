package com.example.demo.service.impl;

import com.example.demo.entity.RateLimitEnforcement;
import com.example.demo.repository.RateLimitEnforcementRepository;
import com.example.demo.service.RateLimitEnforcementService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class RateLimitEnforcementServiceImpl
        implements RateLimitEnforcementService {

    private final RateLimitEnforcementRepository repository;

    public RateLimitEnforcementServiceImpl(
            RateLimitEnforcementRepository repository) {
        this.repository = repository;
    }

    @Override
    public RateLimitEnforcement createEnforcement(
            RateLimitEnforcement enforcement) {

        enforcement.setBlockedAt(
                new Timestamp(System.currentTimeMillis()));
        return repository.save(enforcement);
    }

    @Override
    public RateLimitEnforcement getEnforcementById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("RateLimitEnforcement not found"));
    }

    @Override
    public List<RateLimitEnforcement> getAllEnforcements() {
        return repository.findAll();
    }
}

package com.example.demo.service.impl;

import com.example.demo.entity.QuotaPlan;
import com.example.demo.repository.QuotaPlanRepository;
import com.example.demo.service.QuotaPlanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuotaPlanServiceImpl implements QuotaPlanService {

    private final QuotaPlanRepository quotaPlanRepository;

    public QuotaPlanServiceImpl(QuotaPlanRepository quotaPlanRepository) {
        this.quotaPlanRepository = quotaPlanRepository;
    }

    @Override
    public QuotaPlan createPlan(QuotaPlan plan) {
        plan.setActive(true);
        return quotaPlanRepository.save(plan);
    }

    @Override
    public QuotaPlan updatePlan(Long id, QuotaPlan plan) {
        QuotaPlan existing = quotaPlanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("QuotaPlan not found"));

        existing.setPlanName(plan.getPlanName());
        existing.setDailyLimit(plan.getDailyLimit());
        existing.setDescription(plan.getDescription());

        return quotaPlanRepository.save(existing);
    }

    @Override
    public QuotaPlan getPlanById(Long id) {
        return quotaPlanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("QuotaPlan not found"));
    }

    @Override
    public List<QuotaPlan> getAllPlans() {
        return quotaPlanRepository.findAll();
    }

    @Override
    public void deactivatePlan(Long id) {
        QuotaPlan plan = quotaPlanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("QuotaPlan not found"));

        plan.setActive(false);
        quotaPlanRepository.save(plan);
    }
}

package com.example.demo.service.impl;

import com.example.demo.entity.QuotaPlan;
import com.example.demo.repository.QuotaPlanRepository;
import com.example.demo.service.QuotaPlanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuotaPlanServiceImpl implements QuotaPlanService {

    private final QuotaPlanRepository repository;

    public QuotaPlanServiceImpl(QuotaPlanRepository repository) {
        this.repository = repository;
    }

    @Override
    public QuotaPlan create(QuotaPlan plan) {
        return repository.save(plan);
    }

    @Override
    public QuotaPlan update(Long id, QuotaPlan plan) {
        QuotaPlan existing = getById(id);
        existing.setPlanName(plan.getPlanName());
        existing.setDailyLimit(plan.getDailyLimit());
        existing.setDescription(plan.getDescription());
        return repository.save(existing);
    }

    @Override
    public QuotaPlan getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("QuotaPlan not found"));
    }

    @Override
    public List<QuotaPlan> getAll() {
        return repository.findAll();
    }

    @Override
    public void deactivate(Long id) {
        QuotaPlan plan = getById(id);
        plan.setActive(false);
        repository.save(plan);
    }
}

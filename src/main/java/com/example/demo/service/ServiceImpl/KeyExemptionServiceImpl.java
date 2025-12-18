package com.example.demo.service.impl;

import com.example.demo.entity.KeyExemption;
import com.example.demo.repository.KeyExemptionRepository;
import com.example.demo.service.KeyExemptionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeyExemptionServiceImpl implements KeyExemptionService {

    private final KeyExemptionRepository repository;

    public KeyExemptionServiceImpl(KeyExemptionRepository repository) {
        this.repository = repository;
    }

    @Override
    public KeyExemption createExemption(KeyExemption exemption) {
        return repository.save(exemption);
    }

    @Override
    public KeyExemption updateExemption(Long id, KeyExemption exemption) {
        KeyExemption existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("KeyExemption not found"));

        existing.setNotes(exemption.getNotes());
        existing.setUnlimitedAccess(exemption.getUnlimitedAccess());
        existing.setTemporaryExtensionLimit(
                exemption.getTemporaryExtensionLimit());
        existing.setValidUntil(exemption.getValidUntil());

        return repository.save(existing);
    }

    @Override
    public KeyExemption getExemptionById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("KeyExemption not found"));
    }

    @Override
    public List<KeyExemption> getAllExemptions() {
        return repository.findAll();
    }
}

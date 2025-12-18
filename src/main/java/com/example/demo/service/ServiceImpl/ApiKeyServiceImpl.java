package com.example.demo.service.impl;

import com.example.demo.entity.ApiKey;
import com.example.demo.repository.ApiKeyRepository;
import com.example.demo.service.ApiKeyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiKeyServiceImpl implements ApiKeyService {

    private final ApiKeyRepository apiKeyRepository;

    public ApiKeyServiceImpl(ApiKeyRepository apiKeyRepository) {
        this.apiKeyRepository = apiKeyRepository;
    }

    @Override
    public ApiKey create(ApiKey apiKey) {
        return apiKeyRepository.save(apiKey);
    }

    @Override
    public ApiKey update(Long id, ApiKey apiKey) {
        ApiKey existing = getById(id);
        existing.setKeyValue(apiKey.getKeyValue());
        existing.setQuotaPlan(apiKey.getQuotaPlan());
        return apiKeyRepository.save(existing);
    }

    @Override
    public ApiKey getById(Long id) {
        return apiKeyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ApiKey not found"));
    }

    @Override
    public List<ApiKey> getAll() {
        return apiKeyRepository.findAll();
    }

    @Override
    public void deactivate(Long id) {
        ApiKey apiKey = getById(id);
        apiKey.setActive(false);
        apiKeyRepository.save(apiKey);
    }
}

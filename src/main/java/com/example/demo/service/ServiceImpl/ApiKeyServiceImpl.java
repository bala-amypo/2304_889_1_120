package com.example.demo.service.impl;

import com.example.demo.enity.ApiKey;
import com.example.demo.repository.ApiKeyRepository;
import com.example.demo.service.ApiKeyService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ApiKeyServiceImpl implements ApiKeyService {

    private final ApiKeyRepository apiKeyRepository;

    public ApiKeyServiceImpl(ApiKeyRepository apiKeyRepository) {
        this.apiKeyRepository = apiKeyRepository;
    }

    @Override
    public ApiKey createApiKey(ApiKey apiKey) {
        apiKey.setActive(true);
        apiKey.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        apiKey.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return apiKeyRepository.save(apiKey);
    }

    @Override
    public ApiKey updateApiKey(Long id, ApiKey apiKey) {
        ApiKey existing = apiKeyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("API Key not found"));

        existing.setKeyValue(apiKey.getKeyValue());
        existing.setOwnerId(apiKey.getOwnerId());
        existing.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        return apiKeyRepository.save(existing);
    }

    @Override
    public ApiKey getApiKeyById(Long id) {
        return apiKeyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("API Key not found"));
    }

    @Override
    public List<ApiKey> getAllApiKeys() {
        return apiKeyRepository.findAll();
    }

    @Override
    public void deactivateApiKey(Long id) {
        ApiKey apiKey = apiKeyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("API Key not found"));

        apiKey.setActive(false);
        apiKey.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        apiKeyRepository.save(apiKey);
    }
}

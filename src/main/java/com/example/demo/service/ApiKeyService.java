package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ApiKey;

public interface ApiKeyService{
    ApiKey create(ApiKey apiKey);
    ApiKey update(Long id,ApiKey apiKey);
    ApiKey getById(Long id);
    List<ApiKey> getAll();
    void deactivate(Long id);
}
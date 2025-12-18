package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ApiKeyEntity;

public interface ApiKeyService{
    ApiKey create(ApiKey api);
    ApiKey update(Long id,ApiKey api);
    ApiKey getById(Long id);
    List<ApiKey> getAll();
    void deactivate(Long id);
}
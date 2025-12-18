package com.example.demo.controller;

import com.example.demo.entity.ApiKey;
import com.example.demo.service.ApiKeyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/api-keys")
public class ApiKeyController {

    private final ApiKeyService apiKeyService;

    public ApiKeyController(ApiKeyService apiKeyService) {
        this.apiKeyService = apiKeyService;
    }

    @PostMapping
    public ApiKey create(@RequestBody ApiKey apiKey) {
        return apiKeyService.create(apiKey);
    }

    @PutMapping("/{id}")
    public ApiKey update(@PathVariable Long id, @RequestBody ApiKey apiKey) {
        return apiKeyService.update(id, apiKey);
    }

    @GetMapping("/{id}")
    public ApiKey getById(@PathVariable Long id) {
        return apiKeyService.getById(id);
    }

    @GetMapping
    public List<ApiKey> getAll() {
        return apiKeyService.getAll();
    }

    @DeleteMapping("/{id}")
    public void deactivate(@PathVariable Long id) {
        apiKeyService.deactivate(id);
    }
}

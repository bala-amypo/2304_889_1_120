package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.ApiKey;
import com.example.demo.service.ApiKeyService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/api-keys")
@Tag(name = "API Keys", description = "Manage API keys")
public class ApiKeyController {

    private final ApiKeyService apiKeyService;

    public ApiKeyController(ApiKeyService apiKeyService) {
        this.apiKeyService = apiKeyService;
    }

    @PostMapping
    public ResponseEntity<ApiKey> create(@RequestBody ApiKey apiKey) {
        ApiKey created = apiKeyService.create(apiKey);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiKey> update(
            @PathVariable Long id,
            @RequestBody ApiKey apiKey) {

        ApiKey updated = apiKeyService.update(id, apiKey);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiKey> getById(@PathVariable Long id) {
        ApiKey apiKey = apiKeyService.getById(id);
        return ResponseEntity.ok(apiKey);
    }

    @GetMapping
    public ResponseEntity<List<ApiKey>> getAll() {
        return ResponseEntity.ok(apiKeyService.getAll());
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {
        apiKeyService.deactivate(id);
        return ResponseEntity.noContent().build();
    }
}

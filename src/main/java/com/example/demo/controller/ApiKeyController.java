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

    // POST / - Create API key
    @PostMapping
    public ResponseEntity<ApiKey> create(@RequestBody ApiKey apiKey) {
        ApiKey created = apiKeyService.create(apiKey);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // PUT /{id} - Update API key
    @PutMapping("/{id}")
    public ResponseEntity<ApiKey> update(
            @PathVariable Long id,
            @RequestBody ApiKey apiKey) {

        ApiKey updated = apiKeyService.update(id, apiKey);
        return ResponseEntity.ok(updated);
    }

    // GET /{id} - Get API key by ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiKeyEntity> getById(@PathVariable Long id) {
        ApiKeyEntity apiKey = apiKeyService.getById(id);
        return ResponseEntity.ok(apiKey);
    }

    // GET / - List all keys
    @GetMapping
    public ResponseEntity<List<ApiKeyEntity>> getAll() {
        return ResponseEntity.ok(apiKeyService.getAll());
    }

    // PUT /{id}/deactivate - Deactivate key
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {
        apiKeyService.deactivate(id);
        return ResponseEntity.noContent().build();
    }
}

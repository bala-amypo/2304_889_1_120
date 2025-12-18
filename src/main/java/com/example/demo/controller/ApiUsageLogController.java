package com.example.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/api-keys")
@Tag(name = "API Keys", description = "Manage API keys")
public class ApiKeyController {

    @PostMapping
    @Operation(summary = "Create API Key")
    public String createApiKey() {
        return "API key created";
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update API Key")
    public String updateApiKey(@PathVariable Long id) {
        return "API key updated: " + id;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get API Key by ID")
    public String getApiKey(@PathVariable Long id) {
        return "API key: " + id;
    }

    @GetMapping
    @Operation(summary = "List all API keys")
    public String listApiKeys() {
        return "List of API keys";
    }

    @PutMapping("/{id}/deactivate")
    @Operation(summary = "Deactivate API Key")
    public String deactivateApiKey(@PathVariable Long id) {
        return "API key deactivated: " + id;
    }
}

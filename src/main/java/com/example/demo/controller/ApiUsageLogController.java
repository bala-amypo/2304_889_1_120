package com.example.demo.controller;

import com.example.demo.entity.ApiUsageLog;
import com.example.demo.service.ApiUsageLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usage-logs")
@Tag(name = "API Usage Logs")
public class ApiUsageLogController {

    private final ApiUsageLogService apiUsageLogService;

    public ApiUsageLogController(ApiUsageLogService apiUsageLogService) {
        this.apiUsageLogService = apiUsageLogService;
    }

    // POST /api/usage-logs → Log usage
    @PostMapping
    public ApiUsageLog logUsage(@RequestBody ApiUsageLog usageLog) {
        return apiUsageLogService.logUsage(usageLog);
    }

    // GET /api/usage-logs/key/{keyId} → Get usage for API key
    @GetMapping("/key/{keyId}")
    public List<ApiUsageLog> getUsageByKey(@PathVariable String keyId) {
        return apiUsageLogService.getUsageByKey(keyId);
    }

    // GET /api/usage-logs/key/{keyId}/today → Get today's usage
    @GetMapping("/key/{keyId}/today")
    public List<ApiUsageLog> getTodayUsageByKey(@PathVariable String keyId) {
        return apiUsageLogService.getTodayUsageByKey(keyId);
    }

    // GET /api/usage-logs/key/{keyId}/count-today → Total requests today
    @GetMapping("/key/{keyId}/count-today")
    public long getTodayRequestCountByKey(@PathVariable String keyId) {
        return apiUsageLogService.getTodayRequestCountByKey(keyId);
    }
}

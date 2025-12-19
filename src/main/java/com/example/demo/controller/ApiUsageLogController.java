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

    private final ApiUsageLogService service;

    public ApiUsageLogController(ApiUsageLogService service) {
        this.service = service;
    }

    // POST /api/usage-logs
    @PostMapping
    public ApiUsageLog logUsage(@RequestBody ApiUsageLog usageLog) {
        return service.logUsage(usageLog);
    }

    // GET /api/usage-logs/key/{keyId}
    @GetMapping("/key/{keyId}")
    public List<ApiUsageLog> getUsageByKey(@PathVariable String keyId) {
        return service.getUsageByKey(keyId);
    }

    // GET /api/usage-logs/key/{keyId}/today
    @GetMapping("/key/{keyId}/today")
    public List<ApiUsageLog> getTodayUsage(@PathVariable String keyId) {
        return service.getTodayUsageByKey(keyId);
    }

    // GET /api/usage-logs/key/{keyId}/count-today
    @GetMapping("/key/{keyId}/count-today")
    public long getTodayCount(@PathVariable String keyId) {
        return service.getTodayRequestCountByKey(keyId);
    }
}

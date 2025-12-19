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

    @PostMapping
    public ApiUsageLog logUsage(@RequestBody ApiUsageLog usageLog) {
        return service.logUsage(usageLog);
    }

    @GetMapping("/key/{keyId}")
    public List<ApiUsageLog> getUsage(@PathVariable Long keyId) {
        return service.getUsageByApiKey(keyId);
    }

    @GetMapping("/key/{keyId}/today")
    public List<ApiUsageLog> getTodayUsage(@PathVariable Long keyId) {
        return service.getTodayUsageByApiKey(keyId);
    }

    @GetMapping("/key/{keyId}/count-today")
    public long getTodayCount(@PathVariable Long keyId) {
        return service.getTodayRequestCountByApiKey(keyId);
    }
}

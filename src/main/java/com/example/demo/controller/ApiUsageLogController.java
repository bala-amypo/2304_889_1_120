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

    @PostMapping
    public ApiUsageLog logUsage(@RequestBody ApiUsageLog usageLog) {
        return apiUsageLogService.logUsage(usageLog);
    }

    @GetMapping("/today")
    public List<ApiUsageLog> getTodayUsage() {
        return apiUsageLogService.getTodayUsage();
    }

    @GetMapping("/count-today")
    public long getTodayRequestCount() {
        return apiUsageLogService.getTodayRequestCount();
    }
}

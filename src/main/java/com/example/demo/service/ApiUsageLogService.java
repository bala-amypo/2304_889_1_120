package com.example.demo.service;

import com.example.demo.entity.ApiUsageLog;

import java.util.List;

public interface ApiUsageLogService {

    ApiUsageLog logUsage(ApiUsageLog usageLog);

    List<ApiUsageLog> getUsageByApiKey(Long apiKeyId);

    List<ApiUsageLog> getTodayUsageByApiKey(Long apiKeyId);

    long getTodayRequestCountByApiKey(Long apiKeyId);
}

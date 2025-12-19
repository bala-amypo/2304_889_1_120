package com.example.demo.service;

import com.example.demo.entity.ApiUsageLog;

import java.util.List;

public interface ApiUsageLogService {

    ApiUsageLog logUsage(ApiUsageLog usageLog);

    List<ApiUsageLog> getUsageByKey(String keyId);

    List<ApiUsageLog> getTodayUsageByKey(String keyId);

    long getTodayRequestCountByKey(String keyId);
}

package com.example.demo.service;

import com.example.demo.entity.ApiUsageLog;
import java.util.List;

public interface ApiUsageLogService {

    ApiUsageLog logUsage(ApiUsageLog usageLog);

    List<ApiUsageLog> getTodayUsage();

    long getTodayRequestCount();
}

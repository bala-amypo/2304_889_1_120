package com.example.demo.service.impl;

import com.example.demo.entity.ApiUsageLog;
import com.example.demo.repository.ApiUsageLogRepository;
import com.example.demo.service.ApiUsageLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ApiUsageLogServiceImpl implements ApiUsageLogService {

    private final ApiUsageLogRepository apiUsageLogRepository;

    public ApiUsageLogServiceImpl(ApiUsageLogRepository apiUsageLogRepository) {
        this.apiUsageLogRepository = apiUsageLogRepository;
    }

    @Override
    public ApiUsageLog logUsage(ApiUsageLog usageLog) {
        usageLog.setTimestamp(LocalDateTime.now());
        return apiUsageLogRepository.save(usageLog);
    }

    @Override
    public List<ApiUsageLog> getUsageByKey(String keyId) {
        return apiUsageLogRepository.findByKeyId(keyId);
    }

    @Override
    public List<ApiUsageLog> getTodayUsageByKey(String keyId) {
        LocalDate today = LocalDate.now();
        return apiUsageLogRepository.findByKeyIdAndDate(keyId, today);
    }

    @Override
    public long getTodayRequestCountByKey(String keyId) {
        LocalDate today = LocalDate.now();
        return apiUsageLogRepository.countByKeyIdAndDate(keyId, today);
    }
}

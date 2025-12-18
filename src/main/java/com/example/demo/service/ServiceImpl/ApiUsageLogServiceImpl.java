package com.example.demo.service.impl;

import com.example.demo.entity.ApiUsageLog;
import com.example.demo.repository.ApiUsageLogRepository;
import com.example.demo.service.ApiUsageLogService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
public class ApiUsageLogServiceImpl implements ApiUsageLogService {

    private final ApiUsageLogRepository apiUsageLogRepository;

    public ApiUsageLogServiceImpl(ApiUsageLogRepository apiUsageLogRepository) {
        this.apiUsageLogRepository = apiUsageLogRepository;
    }

    @Override
    public ApiUsageLog logUsage(ApiUsageLog usageLog) {
        usageLog.setTimestamp(new Timestamp(System.currentTimeMillis()));
        return apiUsageLogRepository.save(usageLog);
    }

    @Override
    public List<ApiUsageLog> getTodayUsage() {
        Timestamp startOfDay = Timestamp.valueOf(
                LocalDate.now().atStartOfDay()
        );
        Timestamp endOfDay = Timestamp.valueOf(
                LocalDate.now().plusDays(1).atStartOfDay()
        );

        return apiUsageLogRepository.findByTimestampBetween(startOfDay, endOfDay);
    }

    @Override
    public long getTodayRequestCount() {
        Timestamp startOfDay = Timestamp.valueOf(
                LocalDate.now().atStartOfDay()
        );
        Timestamp endOfDay = Timestamp.valueOf(
                LocalDate.now().plusDays(1).atStartOfDay()
        );

        return apiUsageLogRepository.countByTimestampBetween(startOfDay, endOfDay);
    }
}

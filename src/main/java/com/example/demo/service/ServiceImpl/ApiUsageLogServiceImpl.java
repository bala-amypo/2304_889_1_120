package com.example.demo.service.ServiceImpl;

import com.example.demo.entity.ApiUsageLog;
import com.example.demo.repository.ApiUsageLogRepository;
import com.example.demo.service.ApiUsageLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class ApiUsageLogServiceImpl implements ApiUsageLogService {

    private final ApiUsageLogRepository repository;

    public ApiUsageLogServiceImpl(ApiUsageLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public ApiUsageLog logUsage(ApiUsageLog usageLog) {
        usageLog.setTimestamp(LocalDateTime.now());
        return repository.save(usageLog);
    }

    @Override
    public List<ApiUsageLog> getUsageByKey(String keyId) {
        return repository.findByKeyId(keyId);
    }

    @Override
    public List<ApiUsageLog> getTodayUsageByKey(String keyId) {
        LocalDate today = LocalDate.now();
        LocalDateTime start = today.atStartOfDay();
        LocalDateTime end = today.plusDays(1).atStartOfDay();

        return repository.findTodayUsage(keyId, start, end);
    }

    @Override
    public long getTodayRequestCountByKey(String keyId) {
        LocalDate today = LocalDate.now();
        LocalDateTime start = today.atStartOfDay();
        LocalDateTime end = today.plusDays(1).atStartOfDay();

        return repository.countTodayUsage(keyId, start, end);
    }
}

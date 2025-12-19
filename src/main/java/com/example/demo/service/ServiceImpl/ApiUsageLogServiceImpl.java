package com.example.demo.service.ServiceImpl;

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

    private final ApiUsageLogRepository repository;

    public ApiUsageLogServiceImpl(ApiUsageLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public ApiUsageLog logUsage(ApiUsageLog usageLog) {
        usageLog.setTimestamp(new Timestamp(System.currentTimeMillis()));
        return repository.save(usageLog);
    }

    @Override
    public List<ApiUsageLog> getUsageByApiKey(Long apiKeyId) {
        return repository.findByApiKey_Id(apiKeyId);
    }

    @Override
    public List<ApiUsageLog> getTodayUsageByApiKey(Long apiKeyId) {
        Timestamp start = Timestamp.valueOf(
                LocalDate.now().atStartOfDay()
        );
        Timestamp end = Timestamp.valueOf(
                LocalDate.now().plusDays(1).atStartOfDay()
        );

        return repository.findTodayUsage(apiKeyId, start, end);
    }

    @Override
    public long getTodayRequestCountByApiKey(Long apiKeyId) {
        Timestamp start = Timestamp.valueOf(
                LocalDate.now().atStartOfDay()
        );
        Timestamp end = Timestamp.valueOf(
                LocalDate.now().plusDays(1).atStartOfDay()
        );

        return repository.countTodayUsage(apiKeyId, start, end);
    }
}

package com.example.demo.service;

import com.example.demo.entity.ApiUsageLog;

import java.util.List;

public interface ApiUsageLogService {

    ApiUsageLog save(ApiUsageLog apiUsageLog);

    ApiUsageLog getById(Long id);

    List<ApiUsageLog> getAll();

    void deleteById(Long id);
}

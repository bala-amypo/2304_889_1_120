package com.example.demo.repository;

import com.example.demo.entity.ApiUsageLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ApiUsageLogRepository extends JpaRepository<ApiUsageLog, Long> {

    List<ApiUsageLog> findByKeyId(String keyId);

    @Query("SELECT a FROM ApiUsageLog a WHERE a.keyId = :keyId AND DATE(a.timestamp) = :date")
    List<ApiUsageLog> findByKeyIdAndDate(String keyId, LocalDate date);

    @Query("SELECT COUNT(a) FROM ApiUsageLog a WHERE a.keyId = :keyId AND DATE(a.timestamp) = :date")
    long countByKeyIdAndDate(String keyId, LocalDate date);
}

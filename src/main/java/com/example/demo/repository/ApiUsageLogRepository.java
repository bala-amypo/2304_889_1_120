package com.example.demo.repository;

import com.example.demo.entity.ApiUsageLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ApiUsageLogRepository extends JpaRepository<ApiUsageLog, Long> {

    // All usage for API key
    List<ApiUsageLog> findByKeyId(String keyId);

    // Today's usage for API key
    @Query("""
        SELECT a FROM ApiUsageLog a
        WHERE a.keyId = :keyId
        AND a.timestamp >= :start
        AND a.timestamp < :end
    """)
    List<ApiUsageLog> findTodayUsage(
            String keyId,
            LocalDateTime start,
            LocalDateTime end
    );

    // Count today's requests for API key
    @Query("""
        SELECT COUNT(a) FROM ApiUsageLog a
        WHERE a.keyId = :keyId
        AND a.timestamp >= :start
        AND a.timestamp < :end
    """)
    long countTodayUsage(
            String keyId,
            LocalDateTime start,
            LocalDateTime end
    );
}

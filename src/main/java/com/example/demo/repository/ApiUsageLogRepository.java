package com.example.demo.repository;

import com.example.demo.entity.ApiUsageLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

public interface ApiUsageLogRepository extends JpaRepository<ApiUsageLog, Long> {

    // All usage by API key ID
    List<ApiUsageLog> findByApiKey_Id(Long apiKeyId);

    // Today's usage
    @Query("""
        SELECT a FROM ApiUsageLog a
        WHERE a.apiKey.id = :apiKeyId
        AND a.timestamp >= :start
        AND a.timestamp < :end
    """)
    List<ApiUsageLog> findTodayUsage(
            Long apiKeyId,
            Timestamp start,
            Timestamp end
    );

    // Count today's usage
    @Query("""
        SELECT COUNT(a) FROM ApiUsageLog a
        WHERE a.apiKey.id = :apiKeyId
        AND a.timestamp >= :start
        AND a.timestamp < :end
    """)
    long countTodayUsage(
            Long apiKeyId,
            Timestamp start,
            Timestamp end
    );
}

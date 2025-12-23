package com.example.demo.repository;

import com.example.demo.entity.ApiUsageLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

public interface ApiUsageLogRepository extends JpaRepository<ApiUsageLog, Long> {

    List<ApiUsageLog> findByApiKey_Id(Long apiKeyId);

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

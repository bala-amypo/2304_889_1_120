package com.example.demo.entity;

import java.sql.Timestamp;
import jakarta.persistence.*;

@Entity
@Table(name = "rate_limit_enforcements")
public class RateLimitEnforcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Timestamp blockedAt;

    private int limitExceededBy;

    private String message;

    public RateLimitEnforcement() {
    }

    public RateLimitEnforcement(Long id, Timestamp blockedAt,
                                int limitExceededBy, String message) {
        this.id = id;
        this.blockedAt = blockedAt;
        this.limitExceededBy = limitExceededBy;
        this.message = message;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getBlockedAt() {
        return blockedAt;
    }
    public void setBlockedAt(Timestamp blockedAt) {
        this.blockedAt = blockedAt;
    }

    public int getLimitExceededBy() {
        return limitExceededBy;
    }
    public void setLimitExceededBy(int limitExceededBy) {
        this.limitExceededBy = limitExceededBy;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}

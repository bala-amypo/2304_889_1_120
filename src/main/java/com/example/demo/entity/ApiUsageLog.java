package com.example.demo.entity;

import java.sql.Timestamp;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class ApiUsageLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String endpoint;
    private Timestamp timestamp;

    public ApiUsageLog() {
    }

    public ApiUsageLog(Long id, String endpoint, Timestamp timestamp) {
        this.id = id;
        this.endpoint = endpoint;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEndpoint() {
        return endpoint;
    }
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
    public Timestamp getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
    
}

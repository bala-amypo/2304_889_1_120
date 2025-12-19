package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "api_keys")
public class ApiKey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String keyValue;

    private boolean active = true;

    @ManyToOne
    @JoinColumn(name = "quota_plan_id")
    private QuotaPlan quotaPlan;

    public Long getId() {
        return id;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public QuotaPlan getQuotaPlan() {
        return quotaPlan;
    }

    public void setQuotaPlan(QuotaPlan quotaPlan) {
        this.quotaPlan = quotaPlan;
    }
}

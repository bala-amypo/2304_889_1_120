package com.example.demo.enity;
import java.util.*;
import java.sql.Timestamp;
import jakarta.persistence.*;

public class ApiKeyEntity {
    @Table(name="ApiKey")

    @Id
    private Long id; 

    @Column(unique=true)              
    private String keyValue;  

    private Long ownerId;

         
    private QuotaPlan plan;         
    private Boolean active;         
    private Timestamp createdAt;    
    private Timestamp updatedAt;    

    public ApiKeyEntity(Long id, String keyValue, Long ownerId, QuotaPlan plan, Boolean active, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.keyValue = keyValue;
        this.ownerId = ownerId;
        this.plan = plan;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public ApiKeyEntity() {
        this.active = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public QuotaPlan getPlan() {
        return plan;
    }

    public void setPlan(QuotaPlan plan) {
        this.plan = plan;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}

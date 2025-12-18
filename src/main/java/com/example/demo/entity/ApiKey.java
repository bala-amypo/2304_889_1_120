package com.example.demo.entity;

import java.sql.Timestamp;
import jakarta.persistence.*;

@Entity
@Table(name = "api_keys")
public class ApiKey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String keyValue;

    private Long ownerId;

    private Boolean active;

    private Timestamp createdAt;
    private Timestamp updatedAt;

    public ApiKey() {
        this.active = true;
    }

    public ApiKey(Long id, String keyValue, Long ownerId,
                  Boolean active, Timestamp createdAt,
                  Timestamp updatedAt) {
        this.id = id;
        this.keyValue = keyValue;
        this.ownerId = ownerId;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

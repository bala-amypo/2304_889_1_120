package com.example.demo.entity;

import java.sql.Timestamp;
import jakarta.persistence.*;

@Entity
@Table(name = "key_exemptions")
public class KeyExemption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String notes;

    private Boolean unlimitedAccess;

    private Integer temporaryExtensionLimit;

    private Timestamp validUntil;

    public KeyExemption() {}

    public KeyExemption(Long id, String notes, Boolean unlimitedAccess,
                        Integer temporaryExtensionLimit, Timestamp validUntil) {
        this.id = id;
        this.notes = notes;
        this.unlimitedAccess = unlimitedAccess;
        this.temporaryExtensionLimit = temporaryExtensionLimit;
        this.validUntil = validUntil;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public Boolean getUnlimitedAccess() { return unlimitedAccess; }
    public void setUnlimitedAccess(Boolean unlimitedAccess) {
        this.unlimitedAccess = unlimitedAccess;
    }

    public Integer getTemporaryExtensionLimit() {
        return temporaryExtensionLimit;
    }
    public void setTemporaryExtensionLimit(Integer temporaryExtensionLimit) {
        this.temporaryExtensionLimit = temporaryExtensionLimit;
    }

    public Timestamp getValidUntil() { return validUntil; }
    public void setValidUntil(Timestamp validUntil) {
        this.validUntil = validUntil;
    }
}

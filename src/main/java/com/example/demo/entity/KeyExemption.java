package com.example.demo.entity;

import java.sql.Timestamp;

@Entity
public class KeyExemption(){
   private Long id;
   private String notes;
   private Boolean unlimitedAccess;
   private Integer temporaryExtensionLimit;
   private Timestamp validUntil;
   
   public () {
    }

   public RateLimitEnforcement(Long id, String notes, Boolean unlimitedAccess, Integer temporaryExtensionLimit,
        Timestamp validUntil) {
    this.id = id;
    this.notes = notes;
    this.unlimitedAccess = unlimitedAccess;
    this.temporaryExtensionLimit = temporaryExtensionLimit;
    this.validUntil = validUntil;
    }
   public Long getId() {
    return id;
   }
   public void setId(Long id) {
    this.id = id;
   }
   public String getNotes() {
    return notes;
   }
   public void setNotes(String notes) {
    this.notes = notes;
   }
   public Boolean getUnlimitedAccess() {
    return unlimitedAccess;
   }
   public void setUnlimitedAccess(Boolean unlimitedAccess) {
    this.unlimitedAccess = unlimitedAccess;
   }
   public Integer getTemporaryExtensionLimit() {
    return temporaryExtensionLimit;
   }
   public void setTemporaryExtensionLimit(Integer temporaryExtensionLimit) {
    this.temporaryExtensionLimit = temporaryExtensionLimit;
   }
   public Timestamp getValidUntil() {
    return validUntil;
   }
   public void setValidUntil(Timestamp validUntil) {
    this.validUntil = validUntil;
   }

}
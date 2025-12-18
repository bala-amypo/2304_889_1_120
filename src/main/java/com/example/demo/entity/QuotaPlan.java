package com.example.demo.entity;
import jakarta.persistence.*;

public class QuotaPlan(){
    @Id
    private Long id;
    private String planName;
    private int dailyLimit;
    private String description;
    private Boolean active;
}
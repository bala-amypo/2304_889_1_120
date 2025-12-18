package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "quota_plans")
public class QuotaPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Min(1)
    private int requestLimit;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRequestLimit() {
        return requestLimit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRequestLimit(int requestLimit) {
        this.requestLimit = requestLimit;
    }
}

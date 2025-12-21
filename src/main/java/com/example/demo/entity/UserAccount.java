package com.example.apiratelimiter.entity;

import jakarta.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "user_account",
       uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_quota_plan",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "plan_id"))
    private Set<QuotaPlan> quotaPlans = new HashSet<>();

    public UserAccount() {}

    public UserAccount(Long id, String email, String password, String role, Set<QuotaPlan> quotaPlans) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.quotaPlans = quotaPlans;
    }

    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
    public Set<QuotaPlan> getQuotaPlans() { return quotaPlans; }

    public void setId(Long id) { this.id = id; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setRole(String role) { this.role = role; }
    public void setQuotaPlans(Set<QuotaPlan> quotaPlans) { this.quotaPlans = quotaPlans; }
}

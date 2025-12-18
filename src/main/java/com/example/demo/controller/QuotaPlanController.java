package com.example.demo.controller;

import com.example.demo.entity.QuotaPlan;
import com.example.demo.service.QuotaPlanService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quota-plans")
@Tag(name = "Quota Plans")
public class QuotaPlanController {

    private final QuotaPlanService quotaPlanService;

    public QuotaPlanController(QuotaPlanService quotaPlanService) {
        this.quotaPlanService = quotaPlanService;
    }

    @PostMapping
    public QuotaPlan createPlan(@RequestBody QuotaPlan plan) {
        return quotaPlanService.createPlan(plan);
    }

    @PutMapping("/{id}")
    public QuotaPlan updatePlan(@PathVariable Long id,
                                @RequestBody QuotaPlan plan) {
        return quotaPlanService.updatePlan(id, plan);
    }

    @GetMapping("/{id}")
    public QuotaPlan getPlanById(@PathVariable Long id) {
        return quotaPlanService.getPlanById(id);
    }

    @GetMapping
    public List<QuotaPlan> getAllPlans() {
        return quotaPlanService.getAllPlans();
    }

    @PutMapping("/{id}/deactivate")
    public void deactivatePlan(@PathVariable Long id) {
        quotaPlanService.deactivatePlan(id);
    }
}

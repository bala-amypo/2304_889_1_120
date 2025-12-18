package com.example.demo.controller;

import com.example.demo.entity.QuotaPlan;
import com.example.demo.service.QuotaPlanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quota-plans")
public class QuotaPlanController {

    private final QuotaPlanService quotaPlanService;

    public QuotaPlanController(QuotaPlanService quotaPlanService) {
        this.quotaPlanService = quotaPlanService;
    }

    // CREATE
    @PostMapping
    public QuotaPlan create(@RequestBody QuotaPlan plan) {
        return quotaPlanService.create(plan);
    }

    // UPDATE
    @PutMapping("/{id}")
    public QuotaPlan update(@PathVariable Long id,
                            @RequestBody QuotaPlan plan) {
        return quotaPlanService.update(id, plan);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public QuotaPlan getById(@PathVariable Long id) {
        return quotaPlanService.getById(id);
    }

    // GET ALL
    @GetMapping
    public List<QuotaPlan> getAll() {
        return quotaPlanService.getAll();
    }

    // DEACTIVATE
    @DeleteMapping("/{id}")
    public void deactivate(@PathVariable Long id) {
        quotaPlanService.deactivate(id);
    }
}

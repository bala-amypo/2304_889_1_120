package com.example.demo.controller;

import com.example.demo.entity.KeyExemption;
import com.example.demo.service.KeyExemptionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/key-exemptions")
@Tag(name = "Key Exemptions")
public class KeyExemptionController {

    private final KeyExemptionService keyExemptionService;

    public KeyExemptionController(KeyExemptionService keyExemptionService) {
        this.keyExemptionService = keyExemptionService;
    }

    @PostMapping
    public KeyExemption create(@RequestBody KeyExemption exemption) {
        return keyExemptionService.createExemption(exemption);
    }

    @PutMapping("/{id}")
    public KeyExemption update(@PathVariable Long id,@RequestBody KeyExemption exemption) {
        return keyExemptionService.updateExemption(id, exemption);
    }

    @GetMapping("/{id}")
    public KeyExemption getById(@PathVariable Long id) {
        return keyExemptionService.getExemptionById(id);
    }

    @GetMapping
    public List<KeyExemption> getAll() {
        return keyExemptionService.getAllExemptions();
    }
}

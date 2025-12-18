package com.example.demo.controller;
import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.ApiKeyEntity;
import com.example.demo.repository.ApiKeyRepository;

@RestController
@RequestMapping("/api/keys")
public class ApiKeyController{
    private final ApiKeyRepository a;
    public ApiKeyController(ApiKeyRepository a){
        this.a=a;
    }

    @PostMapping

    @GetMapping()
    @GetMapping
    public List<ApiKeyEntity> getAll(){
        return a.findAll();
    }
}
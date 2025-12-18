package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ApiKeyEntity;

@Repository
public interface Q extends JpaRepository<ApiKeyEntity,Long>{

}
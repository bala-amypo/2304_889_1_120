package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ApiKeyEntity;

@Repository
public interface Repo extends JpaRepository<ApiKeyEntity,Long>{

}
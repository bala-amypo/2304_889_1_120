package com.example.demo.newentity;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlack;

public class StudentValidation{
    @Id
    private Long id;

    @NotBlank(message=no spaces)
    private String name;
    private String email;
}
package com.example.demo.newentity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

public class StudentValidation{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="no empty spaces")
    private String name;

    @NotBlank(message="no spaces")
    @Email(message="Invalid")
    private String email;

    public class StudentValidation(){
        
    }
    
}
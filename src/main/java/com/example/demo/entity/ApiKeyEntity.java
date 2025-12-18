package com.example.demo.entity

public class ApiKeyEntity(){
    @Id;
    private Long id;


    private String keyValue;
    private Long ownerId;
    private ManyToOne plan;
    private Boolean active;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public class ApiKeyEntity(){

    }


}
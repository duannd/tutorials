package com.duannd.springboot.mvc.models;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateStudentResponse {

    private String id;
    private String name;

    public CreateStudentResponse() {
        this(null);
    }

    public CreateStudentResponse(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

}

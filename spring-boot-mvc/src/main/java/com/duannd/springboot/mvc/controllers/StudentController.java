package com.duannd.springboot.mvc.controllers;

import com.duannd.springboot.mvc.models.CreateStudentRequest;
import com.duannd.springboot.mvc.models.CreateStudentResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@RestController
@RequestMapping("students")
public class StudentController {

    private static final ConcurrentHashMap<String, CreateStudentResponse> CACHE_RESPONSE = new ConcurrentHashMap<>();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateStudentResponse createStudent(@RequestBody CreateStudentRequest request) {
        var student = new CreateStudentResponse(request.getName());
        CACHE_RESPONSE.put(student.getId(), student);
        return student;
    }

    @GetMapping
    public List<CreateStudentResponse> getAllStudents() {
        return new ArrayList<>(CACHE_RESPONSE.values());
    }

    @GetMapping("{id}")
    public CreateStudentResponse getStudent(@PathVariable String id) {
        return CACHE_RESPONSE.get(id);
    }

}

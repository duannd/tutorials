package com.duannd.springboot.mvc.controllers;

import com.duannd.springboot.mvc.models.CreateStudentRequest;
import com.duannd.springboot.mvc.models.CreateStudentResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@RestController
@RequestMapping("students")
public class StudentController {

    private static final ConcurrentHashMap<String, CreateStudentResponse> CACHE_RESPONSE = new ConcurrentHashMap<>();

    private final ObjectMapper objectMapper;

    public StudentController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

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

    /**
     * default @RestController return a application/json type. see {@link RestController}
     * consumes is Content-Type that server is required. In case: Server required a application/json type.
     * if client send to Content-Type is text/plain, server will response "status": 415.
     *
     * @param request is a Student JsonObject
     * @return a Student JsonObject
     */
    @PostMapping(value = "consumes", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity consumesExample(@RequestBody CreateStudentRequest request) {
        var student = new CreateStudentResponse(request.getName());
        CACHE_RESPONSE.put(student.getId(), student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    /**
     * produces in case is Content-Type=application/json in HttpResponse that server response to client.
     * if client send a "Accept != application/json" in header. server will return HttpStatus 406 Not Acceptable
     *
     * @param request is a student JsonObject
     * @return a student JsonObject has Content-Type in response is application/json
     */
    @PostMapping(value = "produces", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity producesExample(@RequestBody CreateStudentRequest request) {
        var student = new CreateStudentResponse(request.getName());
        CACHE_RESPONSE.put(student.getId(), student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    /**
     * Client will send a Content-Type=application/json and it will Accept a text/plain Type
     * Server require a Context-Type=application/json in request and response a Context-Type=text/plain in HttpResponse
     *
     * @param request is Student JsonObject
     * @return a Student but it is string.
     */
    @PostMapping(value = "consumes-produces", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity consumesDiffProduces(@RequestBody CreateStudentRequest request) throws JsonProcessingException {
        var student = new CreateStudentResponse(request.getName());
        CACHE_RESPONSE.put(student.getId(), student);
        // var studentString = this.objectMapper.writeValueAsString(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

}

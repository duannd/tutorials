package com.duannd.springboot.mvc.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By ngdduan@gmail.com at 2019-02-08 09:32
 */
@Slf4j
@RestController
@RequestMapping("bean-scopes")
public class BeanScopeController {

    private ObjectMapper objectMapper;

    @Autowired
    public BeanScopeController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public ObjectNode showScopes() {
        return objectMapper.createObjectNode();
    }

}

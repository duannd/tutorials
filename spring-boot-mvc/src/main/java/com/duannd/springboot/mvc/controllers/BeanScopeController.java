package com.duannd.springboot.mvc.controllers;

import com.duannd.springboot.mvc.SpringMvcApplication;
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
        var objectNode = objectMapper.createObjectNode();
        var prototypeScope1 = SpringMvcApplication.applicationContext.getBean("prototypeScope");
        var prototypeScope2 = SpringMvcApplication.applicationContext.getBean("prototypeScope");
        objectNode.put("prototypeScope1", prototypeScope1.toString());
        objectNode.put("prototypeScope2", prototypeScope2.toString());
        var requestScope1 = SpringMvcApplication.applicationContext.getBean("requestScope");
        var requestScope2 = SpringMvcApplication.applicationContext.getBean("requestScope");
        objectNode.put("requestScope1", requestScope1.toString());
        objectNode.put("requestScope2", requestScope2.toString());
        return objectNode;
    }

}

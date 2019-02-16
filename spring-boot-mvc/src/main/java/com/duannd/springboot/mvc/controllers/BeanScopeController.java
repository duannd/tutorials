package com.duannd.springboot.mvc.controllers;

import com.duannd.springboot.mvc.scopes.PrototypeBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By ngdduan@gmail.com at 2019-02-08 09:32
 */
@Slf4j
@RestController
@RequestMapping("bean-scopes")
public class BeanScopeController implements ApplicationContextAware {

    private ObjectMapper objectMapper;
    private PrototypeBean prototypeBean;
    private ApplicationContext applicationContext;

    @Autowired
    public BeanScopeController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * @param prototypeBean is bean that has prototype scope, but was only injected once.
     */
    @Autowired
    public void setPrototypeBean(PrototypeBean prototypeBean) {
        this.prototypeBean = prototypeBean;
    }

    @Lookup("prototypeScope")
    public PrototypeBean getPrototypeBean() {
        return null;
    }

    @GetMapping
    public ObjectNode showScopes() {
        var objectNode = objectMapper.createObjectNode();
        // Show singleton scope
        var singletonScope = applicationContext.getBean("singleton");
        objectNode.put("singletonScope", singletonScope.toString());

        // Show prototype scope
        // Using direct inject will only inject once.
        objectNode.put("prototypeScope", prototypeBean.toString());
        // The first way: using ApplicationContext to get Bean
        var prototypeScope1 = applicationContext.getBean("prototypeScope");
        objectNode.put("prototypeScope1", prototypeScope1.toString());
        // The second way: using inject method with @Lookup
        var prototypeScope2 = getPrototypeBean();
        objectNode.put("prototypeScope2", prototypeScope2 == null ? null : prototypeScope2.toString());

        // Show requestScope
        var requestScope1 = applicationContext.getBean("requestScope");
        var requestScope2 = applicationContext.getBean("requestScope");
        objectNode.put("requestScope1", requestScope1.toString());
        objectNode.put("requestScope2", requestScope2.toString());
        return objectNode;
    }

}

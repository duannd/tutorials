package com.duannd.springboot.mvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.client.RestTemplate;

/**
 * Created By ngdduan@gmail.com at 10/16/2018 9:48 AM
 */
@Slf4j
@SpringBootApplication
public class SpringMvcApplication {

    private static ApplicationContext applicationContext;

    public static void main(String[] args) {
        applicationContext = SpringApplication.run(SpringMvcApplication.class, args);
        log();
        showBeans();
    }

    /**
     * This show log of applicationContext is AnnotationConfig..Context
     */
    private static void log() {
        log.info("Context: {}", applicationContext);
    }

    /**
     * Default will create 126 bean.
     */
    private static void showBeans() {
        log.info("Beans count: {}", applicationContext.getBeanDefinitionCount());
    }

    @Bean
    @DependsOn(value = {"springMvcApplication"})
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}

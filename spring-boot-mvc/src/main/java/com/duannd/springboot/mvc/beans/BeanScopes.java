package com.duannd.springboot.mvc.beans;

import com.duannd.springboot.mvc.scopes.Singleton;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created By ngdduan@gmail.com at 2019-02-08 09:42
 */
@Configuration
public class BeanScopes {

    @Bean
    @Scope("singleton")
    public Singleton singleton() {
        return new Singleton();
    }

}

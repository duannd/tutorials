package com.duannd.springboot.mvc.beans;

import com.duannd.springboot.mvc.scopes.PrototypeScope;
import com.duannd.springboot.mvc.scopes.RequestScope;
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

    @Bean(name = "prototypeScope")
    @Scope("prototype")
    public PrototypeScope prototypeScope() {
        return new PrototypeScope();
    }

    @Bean(name = "requestScope")
    @org.springframework.web.context.annotation.RequestScope
    public RequestScope requestScope() {
        return new RequestScope();
    }

}

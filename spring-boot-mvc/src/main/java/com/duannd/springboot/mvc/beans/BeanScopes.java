package com.duannd.springboot.mvc.beans;

import com.duannd.springboot.mvc.scopes.PrototypeBean;
import com.duannd.springboot.mvc.scopes.RequestScopeBean;
import com.duannd.springboot.mvc.scopes.SingletonBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.RequestScope;

/**
 * Created By ngdduan@gmail.com at 2019-02-08 09:42
 */
@Configuration
public class BeanScopes {

    @Bean(name = "singleton")
    @Scope("singleton")
    public SingletonBean singleton() {
        return new SingletonBean();
    }

    @Bean(name = "prototypeScope")
    @Scope("prototype")
    public PrototypeBean prototypeScope() {
        return new PrototypeBean();
    }

    @Bean(name = "requestScope")
    @RequestScope
    public RequestScopeBean requestScope() {
        return new RequestScopeBean();
    }

}

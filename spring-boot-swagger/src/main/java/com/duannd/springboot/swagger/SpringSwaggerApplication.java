package com.duannd.springboot.swagger;

import com.duannd.springboot.swagger.models.User;
import com.fasterxml.classmate.TypeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.PathProvider;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created By duan.nd@senseinfosys.com at 10/5/2018 3:48 PM
 */
@SpringBootApplication
@EnableSwagger2
public class SpringSwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSwaggerApplication.class, args);
    }

    private TypeResolver typeResolver;

    @Autowired
    public void setTypeResolver(TypeResolver typeResolver) {
        this.typeResolver = typeResolver;
    }

    @Bean
    public Docket userApi() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("Spring Boot Swagger Example")
                .version("1.0")
                .license("Apache 2.0")
                .description("This is spring boot swagger project")
                .build();
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        docket.select()
                .apis(RequestHandlerSelectors.basePackage("com.duannd.springboot.swagger.controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo)
                .pathMapping("/")
                .host("http://localhost:8085/search-api/v1")
                .additionalModels(typeResolver.resolve(User.class))
        ;

        return docket;
    }

    @Bean
    public UiConfiguration uiConfiguration() {
        return UiConfigurationBuilder.builder()
                .deepLinking(true)
                .displayOperationId(false)
                .defaultModelsExpandDepth(1)
                .defaultModelExpandDepth(1)
                .defaultModelRendering(ModelRendering.EXAMPLE)
                .displayRequestDuration(false)
                .docExpansion(DocExpansion.NONE)
                .filter(false)
                .maxDisplayedTags(null)
                .operationsSorter(OperationsSorter.ALPHA)
                .showExtensions(false)
                .tagsSorter(TagsSorter.ALPHA)
                .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
                .validatorUrl(null)
                .build();
    }

}

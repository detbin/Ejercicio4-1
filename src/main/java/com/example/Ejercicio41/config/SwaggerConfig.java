package com.example.Ejercicio41.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Configuracion Swagger para la generacion de documentacion de la API REST
//http://localhost:3000/swagger.ui/
@Configuration
public class SwaggerConfig {
   @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiDetails(){
        return new ApiInfo(
                "Employee API",
                "1.0",
                "API for managing employees.",
                "Terms of Services",
                "David Perez",
                "licencia",
                "http:/cswdvfw.com");
    }
}
/*@Configuration

public class SwaggerConfig {
    @Bean
    public Docket employeeApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }

    //create api metadata that goes at the top of the generated page
    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Employee API",
                "1.0",
                "API for managing employees.",
                "Terms of Services",
                "David Perez",
                "licencia",
                "http:/cswdvfw.com");
    }
}*/
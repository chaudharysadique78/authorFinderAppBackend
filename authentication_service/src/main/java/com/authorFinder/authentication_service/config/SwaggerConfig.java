package com.authorFinder.authentication_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI inventoryApi() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Authentication API")
                                .description("Authentication API for managing authentication")
                                .version("v1")
                                .license(new License().name("Apache 2.0"))
                                .contact(new Contact().name("Sadique").email("chaudharysadique71@gmail.com"))
                );
    }

}

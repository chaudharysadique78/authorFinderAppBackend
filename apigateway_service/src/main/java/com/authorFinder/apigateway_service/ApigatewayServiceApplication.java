package com.authorFinder.apigateway_service;

import com.authorFinder.apigateway_service.filter.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ApigatewayServiceApplication {

    @Autowired
    AuthenticationFilter filter;
    public static void main(String[] args) {
        SpringApplication.run(ApigatewayServiceApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {

        return builder.routes()
                .route("author_service", r -> r.path("/api/v1/author/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://author-service"))
                .route("user_service", r -> r.path("/api/v1/user/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://user-service"))
                .route("authentication_service", r -> r.path("/api/v1/auth/**")
//                       .filters(f -> f.filter(filter))
                        .uri("lb://authentication-service"))
                .route("favorite_service", r -> r.path("/api/v1/fav/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://favorite-service"))
                .build();
    }


}

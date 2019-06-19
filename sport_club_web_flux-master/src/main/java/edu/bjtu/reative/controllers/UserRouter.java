package edu.bjtu.reative.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class UserRouter {
    @Bean
    public RouterFunction<ServerResponse> routeUser(UserHandler handler) {
        return RouterFunctions
                .route(GET("/users").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
                .andRoute(GET("/user/{id}").and(accept(MediaType.APPLICATION_STREAM_JSON)), handler::findById)
                .andRoute(POST("/user").and(accept(MediaType.APPLICATION_JSON)), handler::save)
                .andRoute(DELETE("/user/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::delete);
    }
}
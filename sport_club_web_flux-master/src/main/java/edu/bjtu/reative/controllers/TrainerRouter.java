package edu.bjtu.reative.controllers;

import edu.bjtu.reative.models.Trainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class TrainerRouter {
    @Bean
    public RouterFunction<ServerResponse> routeTrainer(TrainerHandler handler) {
        return RouterFunctions
                .route(GET("/trainers").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
                .andRoute(GET("/trainer/{id}").and(accept(MediaType.APPLICATION_STREAM_JSON)), handler::findById)
                .andRoute(POST("/trainer").and(accept(MediaType.APPLICATION_JSON)), handler::save)
                .andRoute(DELETE("/trainer/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::delete);
    }
}
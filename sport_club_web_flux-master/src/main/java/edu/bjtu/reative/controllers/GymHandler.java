package edu.bjtu.reative.controllers;

import edu.bjtu.reative.models.Gym;
import edu.bjtu.reative.services.GymService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class GymHandler {
    private final GymService gymService;
    public GymHandler(GymService gymService) {
        this.gymService = gymService;
    }
    public Mono<ServerResponse> findById(ServerRequest request) {
        String id = request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(gymService.findById(id), Gym.class);
    }
    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(gymService.findAll(), Gym.class);
    }
    public Mono<ServerResponse> save(ServerRequest request) {
        System.out.println("111");
        final Mono<Gym> gym = request.bodyToMono(Gym.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(gym.flatMap(gymService::save), Gym.class));
    }
    public Mono<ServerResponse> delete(ServerRequest request) {
        String id = request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(gymService.deleteById(id), Void.class);
    }
}
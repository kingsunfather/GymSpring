package edu.bjtu.reative.controllers;

import edu.bjtu.reative.models.Trainer;
import edu.bjtu.reative.services.TrainerService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component

public class TrainerHandler {
    private final TrainerService trainerService;
    public TrainerHandler(TrainerService t) {
        this.trainerService = t;
    }
    public Mono<ServerResponse> findById(ServerRequest request) {
        String id = request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(trainerService.findById(id), Trainer.class);
    }
    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(trainerService.findAll(), Trainer.class);
    }
    public Mono<ServerResponse> save(ServerRequest request) {
        final Mono<Trainer> trainer = request.bodyToMono(Trainer.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(trainer.flatMap(trainerService::save), Trainer.class));
    }
    public Mono<ServerResponse> delete(ServerRequest request) {
        String id = request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(trainerService.deleteById(id), Void.class);
    }
}


package edu.bjtu.reative.services;

import edu.bjtu.reative.models.Trainer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.stereotype.Service;

public interface TrainerService {
    Mono<Trainer> findById(String id);
    Flux<Trainer> findAll();
    Mono<Trainer> save(Trainer trainer);
    Mono<Void> deleteById(String id);
}

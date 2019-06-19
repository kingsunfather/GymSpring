package edu.bjtu.reative.services;

import edu.bjtu.reative.models.Gym;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GymService {
    Mono<Gym> findById(String id);
    Flux<Gym> findAll();
    Mono<Gym> save(Gym gym);
    Mono<Void> deleteById(String id);
}
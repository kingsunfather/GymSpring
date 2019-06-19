package edu.bjtu.reative.services;

import edu.bjtu.reative.models.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> findById(String id);
    Flux<User> findAll();
    Mono<User> save(User user);
    Mono<Void> deleteById(String id);
}
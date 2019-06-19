package edu.bjtu.reative.services;

import edu.bjtu.reative.models.User;
import edu.bjtu.reative.repositories.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public Mono<User> findById(String id) {
        return userRepository.findById(id);
    }
    @Override
    public Flux<User> findAll() {
        return userRepository.findAll();
    }
    @Override
    public Mono<User> save(User user) {
        return userRepository.save(user);
    }
    @Override
    public Mono<Void> deleteById(String id) {
        return userRepository.deleteById(id);
    }
}
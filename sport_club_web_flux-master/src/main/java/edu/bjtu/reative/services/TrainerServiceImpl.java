package edu.bjtu.reative.services;

import edu.bjtu.reative.models.Trainer;
import edu.bjtu.reative.repositories.TrainerRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.stereotype.Service;

@Service
public class TrainerServiceImpl implements TrainerService {
    private TrainerRepository trainerRepository;
    public TrainerServiceImpl(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }
    @Override
    public Mono<Trainer> findById(String id) {
        return trainerRepository.findById(id);
    }
    @Override
    public Flux<Trainer> findAll() {
        return trainerRepository.findAll();
    }
    @Override
    public Mono<Trainer> save(Trainer trainer) {
        return trainerRepository.save(trainer);
    }
    @Override
    public Mono<Void> deleteById(String id) {
        return trainerRepository.deleteById(id);
    }
}

package edu.bjtu.reative.repositories;

import edu.bjtu.reative.models.Trainer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TrainerRepository extends ReactiveMongoRepository<Trainer, String> {

}

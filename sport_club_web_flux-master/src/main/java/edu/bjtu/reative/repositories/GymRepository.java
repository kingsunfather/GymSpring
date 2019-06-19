package edu.bjtu.reative.repositories;

import edu.bjtu.reative.models.Gym;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface GymRepository extends ReactiveMongoRepository<Gym, String> {

}

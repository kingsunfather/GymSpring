package com.springboot.gym_spring.datasource1.repository;

import com.springboot.gym_spring.datasource1.domain.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer,Integer> {
}

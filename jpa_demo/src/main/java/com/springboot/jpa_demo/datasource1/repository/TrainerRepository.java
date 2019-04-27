package com.springboot.jpa_demo.datasource1.repository;

import com.springboot.jpa_demo.datasource1.domain.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer,Integer> {
}

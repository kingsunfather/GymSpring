package com.springboot.jpa_demo.datasource1.service.imp;

import com.springboot.jpa_demo.datasource1.domain.Trainer;
import com.springboot.jpa_demo.datasource1.repository.TrainerRepository;
import com.springboot.jpa_demo.datasource1.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerServiceImp implements TrainerService {
    @Autowired
    TrainerRepository repository;

    @Override
    public List<Trainer> getallTrainer() {
        return repository.findAll();
    }
}

package com.springboot.gym_spring.controller;

import com.springboot.gym_spring.datasource1.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainController {

    @Autowired
    TrainerService service;
}

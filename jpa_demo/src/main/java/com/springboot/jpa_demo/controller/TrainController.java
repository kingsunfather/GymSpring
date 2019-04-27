package com.springboot.jpa_demo.controller;

import com.springboot.jpa_demo.datasource1.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainController {

    @Autowired
    TrainerService service;
}

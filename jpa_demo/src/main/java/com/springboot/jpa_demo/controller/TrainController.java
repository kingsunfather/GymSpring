package com.springboot.jpa_demo.controller;

import com.springboot.jpa_demo.datasource1.domain.Gym;
import com.springboot.jpa_demo.datasource1.domain.Trainer;
import com.springboot.jpa_demo.datasource1.repository.GymRepository;
import com.springboot.jpa_demo.datasource1.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@RestController
public class TrainController {

    @Autowired
    TrainerService service;

    //为了自动向数据库添加测试数据而引入的
    @Autowired
    GymRepository gymRepository;

    @GetMapping("/api/v1/trainer/test/hateoas")
    public HttpEntity<Trainer> getInfor() {

        int phonePrefix=1881095989;
        int idPrefix=100;
        String location="北京市海淀区北京交通大学";
        String introduction="我的性格类型是";
        int i=1000;
        Gym gymInstance = new Gym(String.valueOf(i), location + String.valueOf(i), String.valueOf(phonePrefix + i));
        Gym gymOK = gymRepository.saveAndFlush(gymInstance);

        //生成一个trainer
        Trainer trainerInstance = new Trainer(String.valueOf(i), String.valueOf(i), String.valueOf(i), introduction, String.valueOf(phonePrefix), gymOK);

        trainerInstance.add(linkTo(methodOn(TrainController.class).getInfor()).withSelfRel());


        return new ResponseEntity<>(trainerInstance, HttpStatus.OK);
    }
}

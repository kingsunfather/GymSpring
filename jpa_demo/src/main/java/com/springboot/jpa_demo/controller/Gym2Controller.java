package com.springboot.jpa_demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.springboot.jpa_demo.datasource2.service.Gym2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Gym2Controller {
    @Autowired
    Gym2Service gym2Service;

    @GetMapping("/allgym2")
    public JSONObject allGym2(){
        return gym2Service.allGym2();
    }
}

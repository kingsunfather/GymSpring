package com.springboot.jpa_demo.datasource1.service;

import com.alibaba.fastjson.JSONObject;
import com.springboot.jpa_demo.datasource1.domain.Trainer;

import java.util.List;

public interface TrainerService {
    List<Trainer> getallTrainer();
    JSONObject addTrainer(Trainer trainer);
}

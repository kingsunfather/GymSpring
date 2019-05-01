package com.springboot.jpa_demo.datasource1.service.imp;

import com.alibaba.fastjson.JSONObject;
import com.springboot.jpa_demo.datasource1.domain.Trainer;
import com.springboot.jpa_demo.datasource1.domain.User;
import com.springboot.jpa_demo.datasource1.repository.TrainerRepository;
import com.springboot.jpa_demo.datasource1.service.TrainerService;
import com.springboot.jpa_demo.utils.ConstantVar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerServiceImp implements TrainerService {
    @Autowired
    TrainerRepository trainerRepository;

    @Override
    public List<Trainer> getallTrainer() {
        return trainerRepository.findAll();
    }

    @Override
    public JSONObject addTrainer(Trainer trainer) {
        JSONObject res=new JSONObject();
        Trainer trainer1 = trainerRepository.save(trainer);

        res.put("data",trainer1);
        res.put("code", ConstantVar.SUCCESSFUL_CODE);
        res.put("message",ConstantVar.SUCCESSFUL_MESSAGE);
        return res;
    }
}

package com.springboot.jpa_demo.datasource2.service.imp;

import com.alibaba.fastjson.JSONObject;
import com.springboot.jpa_demo.datasource2.repository.Gym2Repository;
import com.springboot.jpa_demo.datasource2.service.Gym2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Gym2ServiceImp implements Gym2Service {
    @Autowired
    Gym2Repository gym2Repository;

    @Override
    public JSONObject allGym2() {
        JSONObject res=new JSONObject();
        res.put("data",gym2Repository.findAll());
        return res;
    }
}

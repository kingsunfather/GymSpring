package com.springboot.jpa_demo.datasource1.service;

import com.alibaba.fastjson.JSONObject;
import com.springboot.jpa_demo.datasource1.domain.Gym;
import org.hibernate.mapping.Collection;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GymService {
    List<Gym> getallGym();

    JSONObject update(Gym gym);

    JSONObject findByIdOrName(String id,String name);

    JSONObject findByNameLike(String name);

    JSONObject findByNameContaining(String name);

    JSONObject findByNameIn(Collection name);

    JSONObject findAll(Pageable pageable);

    JSONObject getGymTrainer(String id);

    JSONObject addGym(Gym gym);
}

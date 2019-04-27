package com.springboot.gym_spring.datasource1.service;

import com.alibaba.fastjson.JSONObject;
import com.springboot.gym_spring.datasource1.domain.Gym;
import org.hibernate.mapping.Collection;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GymService {
    public List<Gym> getallGym();

    public JSONObject update(Gym gym);

    public JSONObject findByIdOrName(String id,String name);

    public JSONObject findByNameLike(String name);

    public JSONObject findByNameContaining(String name);

    public JSONObject findByNameIn(Collection name);

    JSONObject findAll(Pageable pageable);

    JSONObject getGymTrainer(String id);
}

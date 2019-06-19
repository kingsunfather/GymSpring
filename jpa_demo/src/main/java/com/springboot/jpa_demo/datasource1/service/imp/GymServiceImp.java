package com.springboot.jpa_demo.datasource1.service.imp;

import com.alibaba.fastjson.JSONObject;
import com.springboot.jpa_demo.datasource1.domain.Gym;
import com.springboot.jpa_demo.datasource1.domain.User;
import com.springboot.jpa_demo.datasource1.repository.GymRepository;
import com.springboot.jpa_demo.datasource1.service.GymService;
import com.springboot.jpa_demo.utils.ConstantVar;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymServiceImp implements GymService {
    @Autowired
    GymRepository gymRepository;

    @Override
    public List<Gym> getallGym() {
        System.out.println("从数据库拿取数据");
        return gymRepository.findAll();
    }

    @KafkaListener(topics = "updateGym", groupId = "group_id")
    public void consumeGymUpdate(Gym gym) {
        JSONObject res = new JSONObject();
        int id = gym.getId();
        Gym valid = gymRepository.findById(id);
        if (valid != null) {
            gymRepository.save(gym);
            res.put("code", 200);
        } else {
            res.put("code", 204);
            res.put("message", "该gym不存在");
        }
        return res;
    }

    @Override
    public JSONObject update(Gym gym) {
        JSONObject res = new JSONObject();
        int id = gym.getId();
        Gym valid = gymRepository.findById(id);
        if (valid != null) {
            gymRepository.save(gym);
            res.put("code", 200);
        } else {
            res.put("code", 204);
            res.put("message", "该gym不存在");
        }
        return res;
    }

    @Override
    public JSONObject findByIdOrName(String id, String name) {
        JSONObject res = new JSONObject();
        res.put("data", gymRepository.findByIdOrName(id, name));
        return res;
    }

    @Override
    public JSONObject findByNameLike(String name) {
        JSONObject res = new JSONObject();
        res.put("data", gymRepository.findByNameLike("%" + name + "%"));
        return res;
    }

    @Override
    public JSONObject findByNameContaining(String name) {
        JSONObject res = new JSONObject();
        res.put("data", gymRepository.findByNameContaining(name));
        return res;
    }

    @Override
    public JSONObject findByNameIn(Collection name) {
        JSONObject res = new JSONObject();
        res.put("data", gymRepository.findByNameIn(name));
        return res;
    }

    @Override
    public JSONObject findAll(Pageable pageable) {
        JSONObject res = new JSONObject();
        res.put("data", gymRepository.findAll(pageable));
        return res;
    }

    /**
     *
     * @param id 体育馆的id
     * @return 根据gym的ID联表查询该gym的所有trainer
     */
    @Override
    public JSONObject getGymTrainer(String id) {
        JSONObject res = new JSONObject();
        res.put("data", gymRepository.getGymTrainer(id));
        return res;
    }

    @Override
    public JSONObject addGym(Gym gym) {
        JSONObject res = new JSONObject();
        Gym gym1 = gymRepository.save(gym);

        res.put("data", gym1);
        res.put("code", ConstantVar.SUCCESSFUL_CODE);
        res.put("message", ConstantVar.SUCCESSFUL_MESSAGE);
        return res;

    }
}

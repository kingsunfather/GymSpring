package com.springboot.gym_spring.controller;


import com.alibaba.fastjson.JSONObject;
import com.springboot.gym_spring.datasource1.domain.Gym;
import com.springboot.gym_spring.datasource1.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;


@RestController
@CacheConfig(cacheNames = {"gymCache"})
public class GymController {

    @Autowired
    GymService gymService;


    @GetMapping("/allgym")
    @Cacheable(key = "targetClass + methodName")
    public JSONObject allgym(){
        JSONObject res=new JSONObject();
        res.put("data",gymService.getallGym());
        return res;
    }

    @PostMapping("/updateGym")
    @CachePut(key = "targetClass + methodName")
    public JSONObject updateGym(@RequestBody Gym gym){
       return gymService.update(gym);
    }

    @PostMapping("/findByIdOrName")
    public JSONObject findByIdOrName(String id,String name){
        return gymService.findByIdOrName(id,name);
    }

    @PostMapping("/findByNameLike")
    public JSONObject findByNameLike(String name){
        return gymService.findByNameLike(name);
    }

    @PostMapping("/findByNameContaining")
    public JSONObject findByNameContaining(String name){
        return gymService.findByNameContaining(name);
    }


    @PostMapping("/findAll")
    public JSONObject findAll(int pageSize,int pageNum){
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        Pageable pageable=new PageRequest(pageNum,pageSize,sort);
        return gymService.findAll(pageable);
    }

    @PostMapping("/getGymTrainerById")
    public JSONObject getGymTrainerById(String id){
        return gymService.getGymTrainer(id);
    }

}
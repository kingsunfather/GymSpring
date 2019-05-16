package com.springboot.jpa_demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.springboot.jpa_demo.datasource2.service.Gym2Service;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Gym2Controller {
    @Autowired
    Gym2Service gym2Service;

    @ApiOperation(value = "获取健身房的所有信息", notes = "从第二个数据源获取健身房的所有信息")
    @GetMapping("/api/v1/gym2/all")
    public JSONObject allGym2(){
        return gym2Service.allGym2();
    }
}

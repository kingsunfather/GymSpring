package com.springboot.jpa_demo.controller;
import com.alibaba.fastjson.JSONObject;
import com.springboot.jpa_demo.datasource1.domain.Gym;
import com.springboot.jpa_demo.datasource1.domain.Trainer;
import com.springboot.jpa_demo.datasource1.domain.User;
import com.springboot.jpa_demo.datasource1.service.GymService;
import com.springboot.jpa_demo.datasource1.service.TrainerService;
import com.springboot.jpa_demo.datasource1.service.UserService;
import com.springboot.jpa_demo.token.UserLoginToken;
import com.springboot.jpa_demo.utils.GetToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    GymService gymService;

    @Autowired
    TrainerService trainerService;

    @RequestMapping("/")
    public ModelAndView init(){
        ModelAndView model=new ModelAndView("login");
        return model;
    }

    @GetMapping("/register")
    public ModelAndView register(){
        ModelAndView modelAndView=new ModelAndView("register");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(Long id,String password){
        ModelAndView modelAndView;
        JSONObject jsonObject=userService.login(id,password);
        if(jsonObject.get("code").equals(200)){
            String token= GetToken.getToken(id,password);
            System.out.println("token is "+token);
            modelAndView=new ModelAndView("mainpage");
            modelAndView.addObject("token",token);
        }else{
            modelAndView=new ModelAndView("login");
            modelAndView.addObject("message",jsonObject.get("message"));
            modelAndView.addObject("id",id);
        }
        return modelAndView;
    }

    @PostMapping("/addUser")
    public ModelAndView addUser(User user){
        JSONObject res=userService.addUser(user);
        ModelAndView modelAndView;
        if(res.get("code").equals(200)){
            modelAndView=new ModelAndView("login");
            modelAndView.addObject("id",res.getJSONObject("data").get("id"));
        }else{
            modelAndView=new ModelAndView("register");
        }
        return modelAndView;
    }

//    @UserLoginToken
    @GetMapping("/mainpage")
    public ModelAndView mainpage(){
        ModelAndView model=new ModelAndView("mainpage");
        List<Gym> gyms=gymService.getallGym();
        model.addObject("gyms",gyms);
        List<Trainer> trainers=trainerService.getallTrainer();
        model.addObject("trainers",trainers);
        return model;
    }

}

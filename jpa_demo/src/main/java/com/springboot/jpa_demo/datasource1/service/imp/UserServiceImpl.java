package com.springboot.jpa_demo.datasource1.service.imp;

import com.alibaba.fastjson.JSONObject;
import com.springboot.jpa_demo.datasource1.domain.User;
import com.springboot.jpa_demo.datasource1.repository.UserRepositpry;
import com.springboot.jpa_demo.datasource1.service.UserService;
import com.springboot.jpa_demo.utils.ConstantVar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepositpry userRepositpry;

    @Override
    public JSONObject addUser(User user) {
        JSONObject res=new JSONObject();
//        Long randomId=System.currentTimeMillis();
//        user.setId(randomId);
        User user1 =userRepositpry.save(user);

        res.put("data",user1);
        res.put("code", ConstantVar.SUCCESSFUL_CODE);
        res.put("message",ConstantVar.SUCCESSFUL_MESSAGE);
        return res;
    }

    @Override
    public JSONObject login(int id,String password) {
        JSONObject res=new JSONObject();
        User user=userRepositpry.findById(id);
        if(user!=null&&user.getPassword().equals(password)){
            res.put("data",user);
            res.put("code", ConstantVar.SUCCESSFUL_CODE);
            res.put("message",ConstantVar.SUCCESSFUL_MESSAGE);
        }else{
            res.put("code", ConstantVar.ID_PASS_INCORRECT);
            res.put("message",ConstantVar.ID_PASS_INCORRECT_MSG);
        }

        return res;
    }


    @Override
    public User findUserById(int userId){
        return userRepositpry.findById(userId);
    }

}

package com.springboot.jpa_demo.datasource1.service;

import com.alibaba.fastjson.JSONObject;
import com.springboot.jpa_demo.datasource1.domain.User;

public interface UserService {

    public JSONObject addUser(User user);

    public JSONObject login(Long id,String password);

    public User findUserById(String userId);
}

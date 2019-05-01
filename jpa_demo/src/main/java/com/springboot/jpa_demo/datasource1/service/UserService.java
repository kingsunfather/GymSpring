package com.springboot.jpa_demo.datasource1.service;

import com.alibaba.fastjson.JSONObject;
import com.springboot.jpa_demo.datasource1.domain.User;

public interface UserService {

    JSONObject addUser(User user);

    JSONObject login(int id,String password);

    User findUserById(int userId);
}

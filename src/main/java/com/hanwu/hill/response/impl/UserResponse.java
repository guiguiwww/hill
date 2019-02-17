package com.hanwu.hill.response.impl;

import com.alibaba.fastjson.JSONObject;
import com.hanwu.hill.response.AbstractResponse;
import com.hanwu.hill.entity.User;
import com.hanwu.hill.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

public class UserResponse extends AbstractResponse {

    public User user;
    public int id;
    @Autowired
    private UserService userService;

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object queryResponse(Object request) {
        JSONObject requestJson = (JSONObject) JSONObject.toJSON(request);
        User query_user = userService.findUserById((int) Integer.parseInt(requestJson.get("id").toString()));

        this.setAzone((String) requestJson.get("Azone"));
        this.setRegion((String) requestJson.get("Region"));
        this.setUser(query_user);
        this.setRequestTime();

        return this.toJson();
    }

    public Object addResponse(Object request, User user) {
        JSONObject requestJson = (JSONObject) JSONObject.toJSON(request);
        user.setUsername((String) requestJson.get("username"));
        user.setPassword((String) requestJson.get("password"));

        int retcode = userService.addUser(user);
        this.setAzone((String) requestJson.get("Azone"));
        this.setRegion((String) requestJson.get("Region"));
        this.setRequestTime();
        if (0 == retcode) {
            this.setSuccess(true);
        } else {
            this.setSuccess(false);
        }

        return this.toJson();
    }
}

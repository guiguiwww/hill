package com.hanwu.hill.api.impl;

import com.hanwu.hill.api.UserApi;
import com.hanwu.hill.entity.User;
import com.hanwu.hill.service.UserService;
import com.hanwu.hill.api.response.impl.UserResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserApiImpl implements UserApi{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserResponse userResponse;
	
	@Override
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/add", produces = {"application/json;charset=UTF-8"})
	public Object addUser(@RequestBody Object request, User user) {
		return userResponse.addResponse(request, user);
	}

	@Override
	@ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/query", produces = {"application/json;charset=UTF-8"})
	public Object findUserById(@RequestBody Object request) {
		return userResponse.queryResponse(request);
	}

}

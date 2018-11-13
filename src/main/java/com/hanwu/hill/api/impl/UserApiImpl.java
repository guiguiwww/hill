package com.hanwu.hill.api.impl;

import com.hanwu.hill.api.UserApi;
import com.hanwu.hill.entity.User;
import com.hanwu.hill.service.UserService;
import com.alibaba.fastjson.JSONObject;

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
	
	@Override
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/add", produces = {"application/json;charset=UTF-8"})
	public Object addUser(@RequestBody Object request, User user) {
		JSONObject parser = (JSONObject) JSONObject.toJSON(request);
		int id = Integer.parseInt(parser.get("id").toString());
		String username = parser.get("username").toString();
		String password = parser.get("password").toString();
		user.setId(id);
		user.setUsername(username);
		user.setPassword(password);
		int retcode = userService.addUser(user);
		return (JSONObject) JSONObject.parseObject(String.format("{'retcode': %d, 'msg': 'Hill'}", retcode));
	}

	@Override
	@ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/query", produces = {"application/json;charset=UTF-8"})
	public Object findUserById(@RequestBody Object request) {
		JSONObject parser = (JSONObject) JSONObject.toJSON(request);
		int requestId = Integer.parseInt(parser.get("id").toString());
		return userService.findUserById(requestId);
	}

}

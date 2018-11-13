package com.hanwu.hill.service;

import com.hanwu.hill.entity.User;
public interface UserService {
	int addUser(User user);
	
	User findUserById(int id);
}

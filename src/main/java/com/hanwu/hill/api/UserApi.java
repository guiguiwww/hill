package com.hanwu.hill.api;

import com.hanwu.hill.entity.User;

public interface UserApi {
	
	Object addUser(Object request, User user);
	
	Object findUserById(Object request);

}

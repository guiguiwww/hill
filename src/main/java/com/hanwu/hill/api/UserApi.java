package com.hanwu.hill.api;

import com.hanwu.hill.api.request.ApiRequest;
import com.hanwu.hill.entity.User;

public interface UserApi {

	Object findUserById(Object request);

	Object addUser(ApiRequest hello, Object request, User user);

}

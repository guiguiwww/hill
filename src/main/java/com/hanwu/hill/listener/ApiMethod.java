package com.hanwu.hill.listener;

import java.io.Serializable;

import com.hanwu.hill.api.request.ApiRequest;

public class ApiMethod<T extends ApiRequest> implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String action;
	
	public String getAction(){
		return action;
	}
	
	public void setAction(String action){
		this.action = action;
	}
}

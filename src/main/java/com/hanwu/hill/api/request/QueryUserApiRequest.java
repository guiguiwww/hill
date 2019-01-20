package com.hanwu.hill.api.request;

public class QueryUserApiRequest extends ApiRequest{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}
}

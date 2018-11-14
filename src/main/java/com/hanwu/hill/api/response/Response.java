package com.hanwu.hill.api.response;

public interface Response {
	
	void setRegion(String region);
	
	void setAzone(String azone);
	
	void setRequestTime();
	
	void setSuccess(boolean Success);
}

package com.hanwu.hill.api.response;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.JSONObject;
import com.hanwu.hill.api.response.Response;;

public abstract class AbstractResponse implements Response{
	
	public String Region;
	
	public String Azone;
	
	public String Datetime;
	
	public boolean Success;

	@Override
	public void setRegion(String Region) {
		this.Region = Region;
	}

	@Override
	public void setAzone(String Azone) {
		this.Azone = Azone;
	}

	@Override
	public void setRequestTime() {
		Date date = new Date( );
	    SimpleDateFormat ftime = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
	    this.Datetime = ftime.format(date);
	}
	
	@Override
	public void setSuccess(boolean Success){
		this.Success = Success;
	}
	
	@Override
	public String toString(){
		return JSONObject.toJSONString(this);
	}
	
	public Object toJson(){
		return JSONObject.toJSON(this);
	}

}

package com.hanwu.hill.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

	
@Controller
@RequestMapping(value = "/index")
public class AbstractPeak {
	
	@ResponseBody
	@RequestMapping(produces = {"application/json;charset=UTF-8"})
	public Object peak() {
		return JSONObject.parse("{'exception': false, 'msg': 'Hello hill'}");
	}
}

package com.hanwu.hill.listener;

import java.util.Map;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import com.hanwu.hill.annotation.Api;
import com.hanwu.hill.annotation.ApiMapping;
import com.hanwu.hill.api.request.ApiRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class ApiMethodSelector implements ApplicationListener<ContextRefreshedEvent>{

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event){
		System.out.println("ApiMethodSelector init ........");
		ApplicationContext context = event.getApplicationContext();
		Map<String, Object> beanMap = context.getBeansWithAnnotation(Api.class);
		for (Map.Entry<String, Object> entry: beanMap.entrySet()){
			analyseBean(entry.getKey(), entry.getValue());
		}
		System.out.println("ApiMethodSelector finish ........");
	}
	
	private <T extends ApiRequest> void analyseBean(String entryKey, Object entryValue){
		Method[] methods = entryValue.getClass().getDeclaredMethods();
		for(Method method: methods){
			Annotation annotation = method.getDeclaredAnnotation(ApiMapping.class);
			if(null != annotation){
				System.out.println(method.getParameters()[0]);
			}
		}
	}

}

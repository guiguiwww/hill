package com.hanwu.hill.listener;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import com.hanwu.hill.annotation.Api;
import com.hanwu.hill.annotation.ApiMapping;
import com.hanwu.hill.api.request.ApiRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class ApiMethodSelector implements
		ApplicationListener<ContextRefreshedEvent> {

	private static Map<String, Object> apiMap = new ConcurrentHashMap<String, Object>();

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("ApiMethodSelector init ........");
		ApplicationContext context = event.getApplicationContext();
		Map<String, Object> beanMap = context.getBeansWithAnnotation(Api.class);
		for (Map.Entry<String, Object> entry : beanMap.entrySet()) {
			analyseBean(entry.getKey(), entry.getValue());
		}
		System.out.println("ApiMethodSelector finish ........");
	}

	private <T extends ApiRequest> void analyseBean(String entryKey,
			Object entryValue) {
		Method[] methods = entryValue.getClass().getDeclaredMethods();
		for (Method method : methods) {
			Annotation annotation = method
					.getDeclaredAnnotation(ApiMapping.class);
			if (null != annotation) {
				continue;
			}
			Class<?>[] paramList = method.getParameterTypes();
			if (paramList.length > 1) {
				throw new ApiException();
			}

			Class<T> param = (Class<T>) paramList[0];

			// for(Class<?> param: method.getParameterTypes()){
			// if(param.getName().equals(ApiRequest.class.getName())){
			// System.out.println("jing jing");
			// }
			// }

		}
	}

}

class ApiException extends RuntimeException {
}

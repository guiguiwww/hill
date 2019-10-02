package com.hanwu.hill.listener;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.hanwu.hill.annotation.Api;
import com.hanwu.hill.annotation.ApiMapping;
import com.hanwu.hill.annotation.ApiParameter;
import com.hanwu.hill.request.ApiRequest;
import com.hanwu.hill.exception.ApiException;

import org.apache.commons.lang.StringUtils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class ApiMethodSelector implements
        ApplicationListener<ContextRefreshedEvent> {

    private static final Map<String, Object> METHOD_MAP = new ConcurrentHashMap<>();

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

    private <T extends ApiRequest> void analyseBean(String beanName, Object beanValue) {
        Method[] methods = beanValue.getClass().getDeclaredMethods();
        System.out.println(String.format("begin to analyse bean %s ........", beanName));
        for (Method method : methods) {
            ApiMapping apiMapping = method.getDeclaredAnnotation(ApiMapping.class);
            if (null == apiMapping) {
                continue;
            }
            String action = apiMapping.value();
            if (StringUtils.isEmpty(action)) {
                action = StringUtils.capitalize(method.getName());
            }
            Class<?>[] paramList = method.getParameterTypes();
            if (paramList.length < 1) {
                throw new ApiException("Parameter error, no ApiRequest init.");
            }
            if (paramList.length > 1) {
                // TODO throw new ApiException("Parameter count error, only api parameter allowed in method.");
            }
            
            @SuppressWarnings("unchecked")
            Class<T> parameterType = (Class<T>) paramList[0];
            List<ApiField> fieldList = getApiRequestFieldsByType(parameterType);
            ApiMethod<T> apiMethod = new ApiMethod<>(action, method, parameterType, fieldList);
            METHOD_MAP.put(action, apiMethod);
        }
    }

    private <T extends ApiRequest> List<ApiField> getApiRequestFieldsByType(Class<T> parameterType) {
        List<ApiField> paramList = new ArrayList<>();
        Field[] fields = parameterType.getDeclaredFields();
        for (Field field : fields) {
            paramList.add(convertToApiField(field));
        }
        return paramList;
    }

    private static ApiField convertToApiField(Field field) {
        String fieldName = field.getName();
        ApiParameter apiParameter = field.getAnnotation(ApiParameter.class);
        if (apiParameter == null) {
            return new ApiField(StringUtils.capitalize(fieldName), fieldName, field.getType());
        }
        String paramName = apiParameter.value();
        if (StringUtils.isEmpty(paramName)) {
            paramName = StringUtils.capitalize(field.getName());
        }
        boolean required = apiParameter.required();
        return new ApiField(required, paramName, fieldName, field.getType());
    }

}

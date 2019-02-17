package com.hanwu.hill.listener;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.List;

import com.hanwu.hill.request.ApiRequest;


public class ApiMethod<T extends ApiRequest> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String action;

    private Method method;

    private Class<T> paramType;

    private List<ApiField> paramFieldList;

    ApiMethod(String action, Method method, Class<T> paramType, List<ApiField> paramFieldList) {
        this.action = action;
        this.method = method;
        this.paramType = paramType;
        this.paramFieldList = paramFieldList;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Class<T> getParamType() {
        return paramType;
    }

    public void setParamType(Class<T> paramType) {
        this.paramType = paramType;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public List<ApiField> getParamFieldList() {
        return paramFieldList;
    }

    public void setParamFieldList(List<ApiField> paramFieldList) {
        this.paramFieldList = paramFieldList;
    }

}

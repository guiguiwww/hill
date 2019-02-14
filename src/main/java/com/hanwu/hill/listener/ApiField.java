package com.hanwu.hill.listener;

import java.lang.reflect.Method;

public class ApiField {

    private static boolean required = true;

    private String paramName;

    private String fieldName;

    private Class<?> fieldType;

    private Method initMethod;

    public ApiField(String paramName, String fieldName, Class<?> fieldType){
        this.paramName = paramName;
        this.fieldName = fieldName;
        this.fieldType = fieldType;
    }

    public ApiField(boolean required, String paramName, String fieldName, Class<?> fieldType) {
        this(paramName, fieldName, fieldType);
        ApiField.required = required;
    }

    public static boolean isRequired() {
        return required;
    }

    public String getParamName() {
        return paramName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Class<?> getFieldType() {
        return fieldType;
    }

    public Method getInitMethod() {
        return initMethod;
    }

    public void setInitMethod(Method initMethod) {
        this.initMethod = initMethod;
    }
}

package com.hanwu.hill.annotation;

import java.lang.annotation.Documented;  
import java.lang.annotation.ElementType;  
import java.lang.annotation.Retention;  
import java.lang.annotation.RetentionPolicy;  
import java.lang.annotation.Target;

/**
 * Api Annotation defined
 * author: stefan
 * */

@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.TYPE)  
@Documented 
public @interface Api {

}

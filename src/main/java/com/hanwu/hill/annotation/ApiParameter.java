package com.hanwu.hill.annotation;

import java.lang.annotation.*;

/**
 * ApiParameter annotation
 * <p>
 * author: stefan
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface ApiParameter {

    public String value() default "";

    public boolean required() default false;
}
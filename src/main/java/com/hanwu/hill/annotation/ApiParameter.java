package com.hanwu.hill.annotation;

import java.lang.annotation.*;

/**
 * ApiParameter annotation
 * <p>
 * author: Stefan
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface ApiParameter {

    String value() default "";

    boolean required() default false;
}

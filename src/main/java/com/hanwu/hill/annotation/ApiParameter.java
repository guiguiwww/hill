package com.hanwu.hill.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ApiParameter annotation
 *
 * @author Stefan
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface ApiParameter {

    public String value() default "";

    public boolean required() default false;
}

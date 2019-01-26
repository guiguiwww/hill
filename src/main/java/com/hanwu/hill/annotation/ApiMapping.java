package com.hanwu.hill.annotation;

import java.lang.annotation.*;

/**
 * ApiMapping annotation
 * <p>
 * author: stefan
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface ApiMapping {

    public String value() default "";
}

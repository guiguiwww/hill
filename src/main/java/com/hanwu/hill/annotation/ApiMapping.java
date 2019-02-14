package com.hanwu.hill.annotation;

import java.lang.annotation.*;

/**
 * ApiMapping annotation
 * <p>
 * author: Stefan
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface ApiMapping {

    String value() default "";
}

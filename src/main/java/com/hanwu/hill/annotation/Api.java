package com.hanwu.hill.annotation;

import java.lang.annotation.*;

/**
 * Api annotation
 * <p>
 * author: stefan
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface Api {
    public String value() default "";
}

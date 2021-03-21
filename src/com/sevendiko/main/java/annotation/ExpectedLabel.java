package com.sevendiko.main.java.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface ExpectedLabel{
    String label() default "";
}

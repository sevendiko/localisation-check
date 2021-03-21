package com.sevendiko.main.java;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface ExpectedLabel{
    String label() default "";
}

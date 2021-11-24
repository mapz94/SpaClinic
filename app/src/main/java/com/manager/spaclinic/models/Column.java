package com.manager.spaclinic.models;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Column {
    public String column_name() default "";

    public String column_props() default "";

    public String setter() default "";

    public String getter() default "";
}

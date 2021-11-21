package com.example.spaclinic.models;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;

@Table(table_name = "")
public abstract class Model<T> {

    public abstract MenuItem getMenuItem();
}

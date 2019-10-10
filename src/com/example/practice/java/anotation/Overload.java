package com.example.practice.java.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Overload {}

/* To test the working of custom anotation and its processor
   javac -processor customProcessor "classes to be compiled"
 */

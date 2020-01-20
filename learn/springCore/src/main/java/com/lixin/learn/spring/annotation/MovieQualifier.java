package com.lixin.learn.spring.annotation;

import com.lixin.learn.spring.enums.MovieFormat;
import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Qualifier
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MovieQualifier {
    String value();

    MovieFormat format();
}

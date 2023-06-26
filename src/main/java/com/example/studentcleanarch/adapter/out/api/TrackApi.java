package com.example.studentcleanarch.adapter.out.api;

import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TrackApi {
    String message() default "TrackApi @";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

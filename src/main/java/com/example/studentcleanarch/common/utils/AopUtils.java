package com.example.studentcleanarch.common.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AopUtils {

    public static boolean isNotMethod(Signature signature) {
        return !(signature instanceof MethodSignature);
    }

    public static Method getMethod(ProceedingJoinPoint joinPoint) {
        return ((MethodSignature) joinPoint.getSignature()).getMethod();
    }

    public static <T extends Annotation> boolean isMethodAnnotationWith(
            ProceedingJoinPoint joinPoint, Class<T> annotation) {
        return getMethod(joinPoint).isAnnotationPresent(annotation);
    }

    public static <T extends Annotation> boolean isNotMethodAnnotationWith(
            ProceedingJoinPoint joinPoint, Class<T> annotation) {
        return !isMethodAnnotationWith(joinPoint, annotation);
    }
}

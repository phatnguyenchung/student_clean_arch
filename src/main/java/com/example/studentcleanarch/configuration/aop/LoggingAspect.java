package com.example.studentcleanarch.configuration.aop;

import com.timo.platform.configurationservice.application.holder.LogRefIdHolder;
import com.timo.platform.configurationservice.application.holder.UserIdHolder;
import com.timo.platform.configurationservice.common.utils.DateTimeUtils;
import com.timo.platform.configurationservice.common.utils.JsonUtils;
import com.timo.platform.configurationservice.common.utils.MaskingObjectGenerator;
import com.timo.platform.configurationservice.configuration.properties.MiscConfigProperties;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.regex.Pattern;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Autowired
    private MiscConfigProperties properties;

    @Autowired
    private Environment environment;

    // @Pointcut("within(com.timo..rest..*)")
    @Pointcut("within(com.timo..api..*) || within(com.timo..service..*)")
    public void timoPointcut() {
        // No code needed
    }

    @Pointcut("timoPointcut() && ignoreClasses()")
    public void loggingPointcut() {
        // No code needed
    }

    @Pointcut("loggingPointcut()")
    public void errorPointcut() {
        // No code needed
    }

    @Pointcut("!execution(* com.timo..ApiCallService..*(..))")
    public void ignoreClasses() {
        // No code needed
    }

    @AfterThrowing(pointcut = "errorPointcut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        Object errorMsg = e.getCause() != null ? e.getCause() : e.getMessage();
        Long userId = UserIdHolder.get();
        Signature signature = joinPoint.getSignature();
        Pattern multilinePattern = MaskingObjectGenerator.loadMaskFields(properties.getMaskFields());
        Object param = MaskingObjectGenerator.mask(
                getParams(((MethodSignature) signature).getParameterNames(), joinPoint.getArgs()), multilinePattern);
        String returnType = ((MethodSignature) signature).getReturnType().getSimpleName();

        Map<String, Object> mapResult = new HashMap<>();
        mapResult.put("methodName", signature.getName());
        mapResult.put("params", param);
        mapResult.put("userId", userId);
        mapResult.put("tracerId", LogRefIdHolder.get());
        mapResult.put("errorMsg", errorMsg);
        String json = JsonUtils.toJson(mapResult);
        String logResult = "failed to execute (" + returnType + " "
                + joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName() + ")";
        // log.error(Markers.appendRaw("details", json), logResult);
        log.error(logResult + " => " + json);
    }

    @Around("loggingPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            long timeStarted = System.currentTimeMillis();
            Object result = joinPoint.proceed();
            long timeEnd = System.currentTimeMillis();
            writeLog(joinPoint, result, timeStarted, timeEnd);
            return result;
        } catch (IllegalArgumentException exception) {
            log.error(
                    "Illegal argument: {} in {}.{}()",
                    Arrays.toString(joinPoint.getArgs()),
                    joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName());
            throw exception;
        }
    }

    private void writeLog(ProceedingJoinPoint joinPoint, Object result, long timeStarted, long timeEnd) {
        Signature signature = joinPoint.getSignature();
        String returnType = ((MethodSignature) signature).getReturnType().getSimpleName();
        Long userId = UserIdHolder.get();
        Map<String, Object> mapResult = new HashMap<>();
        Pattern multilinePattern = MaskingObjectGenerator.loadMaskFields(properties.getMaskFields());
        Object param = MaskingObjectGenerator.mask(
                getParams(((MethodSignature) signature).getParameterNames(), joinPoint.getArgs()), multilinePattern);
        Object output = MaskingObjectGenerator.mask(result, multilinePattern);
        mapResult.put("methodName", signature.getName());
        mapResult.put("params", param);
        mapResult.put(
                "timeStarted",
                DateTimeUtils.format(new Date(timeStarted), DateTimeUtils.DATETIME_FORMAT_WITH_TIMEZONE));
        mapResult.put("timeEnd", DateTimeUtils.format(new Date(timeEnd), DateTimeUtils.DATETIME_FORMAT_WITH_TIMEZONE));
        mapResult.put("duration", timeEnd - timeStarted);
        mapResult.put("userId", userId);
        mapResult.put("tracerId", LogRefIdHolder.get());
        mapResult.put("output", output);
        String json = JsonUtils.toJson(mapResult);
        String logResult =
                "execution(" + returnType + " " + joinPoint.getSignature().getDeclaringTypeName() + "."
                        + joinPoint.getSignature().getName() + ")";
        // log.info(Markers.appendRaw("details", json), logResult);
        log.info(logResult + " => " + json);
    }

    private Map getParams(String[] paramNames, Object[] paramValues) {
        if (Objects.isNull(paramNames)
                || Objects.isNull(paramValues)
                || paramNames.length == 0
                || paramValues.length == 0) {
            return null;
        }
        Map<String, Object> rs = new HashMap<>();
        for (int i = 0; i < paramNames.length; i++) {
            rs.put(paramNames[i], paramValues[i]);
        }
        return rs;
    }
}

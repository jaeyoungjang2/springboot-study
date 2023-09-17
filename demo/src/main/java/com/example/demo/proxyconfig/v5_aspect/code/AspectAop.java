package com.example.demo.proxyconfig.v5_aspect.code;

import com.example.demo.threadlocal.log.LogTrace;
import com.example.demo.threadlocal.log.LogTraceStatus;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;


@Aspect
@RequiredArgsConstructor
public class AspectAop {

    private final LogTrace logTrace;


    @Around("execution(* com.example.demo.proxy..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        LogTraceStatus status = logTrace.begin(joinPoint.getSignature().toShortString());
        Object proceed = joinPoint.proceed();
        logTrace.end(status);
        return proceed;
    }
}

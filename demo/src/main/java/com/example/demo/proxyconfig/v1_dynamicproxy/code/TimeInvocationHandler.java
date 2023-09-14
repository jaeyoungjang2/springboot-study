package com.example.demo.proxyconfig.v1_dynamicproxy.code;

import com.example.demo.threadlocal.log.LogTrace;
import com.example.demo.threadlocal.log.LogTraceStatus;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@RequiredArgsConstructor
public class TimeInvocationHandler implements InvocationHandler {

    private final LogTrace logTrace;
    private final Object target;

    private final String message;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        LogTraceStatus status = logTrace.begin(message);
        Object invoke = method.invoke(target, args);
        logTrace.end(status);
        return invoke;
    }
}

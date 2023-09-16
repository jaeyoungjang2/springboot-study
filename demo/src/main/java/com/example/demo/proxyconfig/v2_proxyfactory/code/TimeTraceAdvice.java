package com.example.demo.proxyconfig.v2_proxyfactory.code;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class TimeTraceAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("Time Proxy 실행");
        long startTime = System.currentTimeMillis();

        // 리플렉션을 사용해서 'target' 인스턴스의 메서드를 실행한다. 'args'는 메서드 호출시 넘겨줄 인수이다.
        Object result = invocation.proceed();

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("Time cglib Proxy 종료 resultTime={}", resultTime);
        log.info("{}", invocation.getClass());
        return result;
    }
}

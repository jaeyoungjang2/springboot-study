package com.example.demo.proxy.cglib.code;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
@RequiredArgsConstructor
public class TimeMethodInterceptor implements MethodInterceptor {

    private final Object target;

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log.info("Time cglib Proxy 실행");
        long startTime = System.currentTimeMillis();

        // 리플렉션을 사용해서 'target' 인스턴스의 메서드를 실행한다. 'args'는 메서드 호출시 넘겨줄 인수이다.
        Object result = method.invoke(target, objects);

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("Time cglib Proxy 종료 resultTime={}", resultTime);
        return result;
    }
}

package com.example.demo.proxyconfig.v2_proxyfactory;

import com.example.demo.proxy.v0.*;
import com.example.demo.proxy.v1.ProxyLogControllerV1;
import com.example.demo.proxy.v1.ProxyLogRepositoryV1;
import com.example.demo.proxy.v1.ProxyLogServiceV1;
import com.example.demo.proxyconfig.v1_dynamicproxy.code.TimeInvocationHandler;
import com.example.demo.proxyconfig.v2_proxyfactory.code.TimeTraceAdvice;
import com.example.demo.threadlocal.log.LogTrace;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;

@Configuration
public class ProxyFactoryConfig {

    @Bean
    public ProxyLogControllerV0 proxyLogControllerV0(LogTrace logTrace) {
        ProxyLogControllerV0Impl proxyLogControllerV0 = new ProxyLogControllerV0Impl(proxyLogServiceV0(logTrace));
        TimeTraceAdvice timeTraceAdvice = new TimeTraceAdvice();
        ProxyFactory proxyFactory = new ProxyFactory(proxyLogControllerV0);
        proxyFactory.addAdvice(timeTraceAdvice);
        ProxyLogControllerV0 proxy = (ProxyLogControllerV0) proxyFactory.getProxy();
        return proxy;
    }

    @Bean
    public ProxyLogServiceV0 proxyLogServiceV0(LogTrace logTrace) {
        ProxyLogServiceV0Impl proxyLogServiceV0 = new ProxyLogServiceV0Impl(proxyLogRepositoryV0(logTrace));
        TimeTraceAdvice timeTraceAdvice = new TimeTraceAdvice();
        ProxyFactory proxyFactory = new ProxyFactory(proxyLogServiceV0);
        proxyFactory.addAdvice(timeTraceAdvice);
        ProxyLogServiceV0 proxy = (ProxyLogServiceV0) proxyFactory.getProxy();
        return proxy;
    }

    @Bean
    public ProxyLogRepositoryV0 proxyLogRepositoryV0(LogTrace logTrace) {
        ProxyLogRepositoryV0Impl proxyLogRepositoryV0 = new ProxyLogRepositoryV0Impl();
        TimeTraceAdvice timeTraceAdvice = new TimeTraceAdvice();
        ProxyFactory proxyFactory = new ProxyFactory(proxyLogRepositoryV0);
        proxyFactory.addAdvice(timeTraceAdvice);
        ProxyLogRepositoryV0 proxy = (ProxyLogRepositoryV0) proxyFactory.getProxy();
        return proxy;
    }

//    구체클래스쪽
    @Bean
    public ProxyLogControllerV1 proxyLogControllerV1(LogTrace logTrace) {
        ProxyLogControllerV1 proxyLogControllerV1 = new ProxyLogControllerV1(proxyLogServiceV1(logTrace));
        TimeTraceAdvice timeTraceAdvice = new TimeTraceAdvice();
        ProxyFactory proxyFactory = new ProxyFactory(proxyLogControllerV1);
        proxyFactory.addAdvice(timeTraceAdvice);
        ProxyLogControllerV1 proxy = (ProxyLogControllerV1) proxyFactory.getProxy();
        return proxy;
    }

    @Bean
    public ProxyLogServiceV1 proxyLogServiceV1(LogTrace logTrace) {
        ProxyLogServiceV1 proxyLogServiceV1 = new ProxyLogServiceV1(proxyLogRepositoryV1(logTrace));
        TimeTraceAdvice timeTraceAdvice = new TimeTraceAdvice();
        ProxyFactory proxyFactory = new ProxyFactory(proxyLogServiceV1);
        proxyFactory.addAdvice(timeTraceAdvice);
        ProxyLogServiceV1 proxy = (ProxyLogServiceV1) proxyFactory.getProxy();
        return proxy;
    }

    @Bean
    public ProxyLogRepositoryV1 proxyLogRepositoryV1(LogTrace logTrace) {
        ProxyLogRepositoryV1 proxyLogRepositoryV1 = new ProxyLogRepositoryV1();
        TimeTraceAdvice timeTraceAdvice = new TimeTraceAdvice();
        ProxyFactory proxyFactory = new ProxyFactory(proxyLogRepositoryV1);
        proxyFactory.addAdvice(timeTraceAdvice);
        ProxyLogRepositoryV1 proxy = (ProxyLogRepositoryV1) proxyFactory.getProxy();
        return proxy;
    }
}

package com.example.demo.proxyconfig.v1_dynamicproxy;

import com.example.demo.proxy.v0.*;
import com.example.demo.proxyconfig.v1_dynamicproxy.code.TimeInvocationHandler;
import com.example.demo.threadlocal.log.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;

@Configuration
public class JdkDynamicProxyConfig {

    @Bean
    public ProxyLogControllerV0 proxyLogControllerV0(LogTrace logTrace) {
        ProxyLogControllerV0Impl proxyLogControllerV0 = new ProxyLogControllerV0Impl(proxyLogServiceV0(logTrace));
        TimeInvocationHandler handler = new TimeInvocationHandler(logTrace, proxyLogControllerV0, "proxyController");
        ProxyLogControllerV0 controllerV0 = (ProxyLogControllerV0) Proxy.newProxyInstance(ProxyLogControllerV0.class.getClassLoader(), new Class[]{ProxyLogControllerV0.class}, handler);
        return controllerV0;
    }

    @Bean
    public ProxyLogServiceV0 proxyLogServiceV0(LogTrace logTrace) {
        ProxyLogServiceV0Impl proxyLogServiceV0 = new ProxyLogServiceV0Impl(proxyLogRepositoryV0(logTrace));
        TimeInvocationHandler handler = new TimeInvocationHandler(logTrace, proxyLogServiceV0, "proxyService");
        ProxyLogServiceV0 serviceV0 = (ProxyLogServiceV0) Proxy.newProxyInstance(ProxyLogServiceV0.class.getClassLoader(), new Class[]{ProxyLogServiceV0.class}, handler);
        return serviceV0;
    }

    @Bean
    public ProxyLogRepositoryV0 proxyLogRepositoryV0(LogTrace logTrace) {
        ProxyLogRepositoryV0Impl proxyLogRepositoryV0 = new ProxyLogRepositoryV0Impl();
        TimeInvocationHandler handler = new TimeInvocationHandler(logTrace, proxyLogRepositoryV0, "proxyRepository");
        ProxyLogRepositoryV0 repositoryV0 = (ProxyLogRepositoryV0) Proxy.newProxyInstance(ProxyLogRepositoryV0.class.getClassLoader(), new Class[]{ProxyLogRepositoryV0.class}, handler);
        return repositoryV0;
    }
}

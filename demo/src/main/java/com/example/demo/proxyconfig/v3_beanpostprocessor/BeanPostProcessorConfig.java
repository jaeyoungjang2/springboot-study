package com.example.demo.proxyconfig.v3_beanpostprocessor;

import com.example.demo.proxy.v0.*;
import com.example.demo.proxy.v1.ProxyLogControllerV1;
import com.example.demo.proxy.v1.ProxyLogRepositoryV1;
import com.example.demo.proxy.v1.ProxyLogServiceV1;
import com.example.demo.proxyconfig.v2_proxyfactory.code.TimeTraceAdvice;
import com.example.demo.proxyconfig.v3_beanpostprocessor.code.TimePostProcessor;
import com.example.demo.threadlocal.log.LogTrace;
import org.springframework.aop.Advisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanPostProcessorConfig {

    @Bean
    public TimePostProcessor timePostProcessor() {
        return new TimePostProcessor("com.example.demo.proxy", advisor());
    }

    @Bean
    public Advisor advisor() {
        return new DefaultPointcutAdvisor(new TimeTraceAdvice());
    }

    @Bean
    public ProxyLogControllerV0 proxyLogControllerV0(LogTrace logTrace) {
        return new ProxyLogControllerV0Impl(proxyLogServiceV0(logTrace));
    }

    @Bean
    public ProxyLogServiceV0 proxyLogServiceV0(LogTrace logTrace) {
        return new ProxyLogServiceV0Impl(proxyLogRepositoryV0(logTrace));
    }

    @Bean
    public ProxyLogRepositoryV0 proxyLogRepositoryV0(LogTrace logTrace) {
        return new ProxyLogRepositoryV0Impl();
    }

    //    구체클래스쪽
    @Bean
    public ProxyLogControllerV1 proxyLogControllerV1(LogTrace logTrace) {
        return new ProxyLogControllerV1(proxyLogServiceV1(logTrace));
    }

    @Bean
    public ProxyLogServiceV1 proxyLogServiceV1(LogTrace logTrace) {
        return new ProxyLogServiceV1(proxyLogRepositoryV1(logTrace));
    }

    @Bean
    public ProxyLogRepositoryV1 proxyLogRepositoryV1(LogTrace logTrace) {
        return new ProxyLogRepositoryV1();
    }
}

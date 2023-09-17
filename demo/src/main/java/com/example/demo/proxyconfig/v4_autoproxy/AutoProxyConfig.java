package com.example.demo.proxyconfig.v4_autoproxy;

import com.example.demo.proxy.v0.*;
import com.example.demo.proxy.v1.ProxyLogControllerV1;
import com.example.demo.proxy.v1.ProxyLogRepositoryV1;
import com.example.demo.proxy.v1.ProxyLogServiceV1;
import com.example.demo.proxyconfig.v2_proxyfactory.code.TimeTraceAdvice;
import com.example.demo.threadlocal.log.LogTrace;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutoProxyConfig {

    @Bean
    public Advisor autoProxy() {
        TimeTraceAdvice timeTraceAdvice = new TimeTraceAdvice();
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression("execution(* com.example.demo.proxy..*(..))");
        DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor(aspectJExpressionPointcut, timeTraceAdvice);
        return defaultPointcutAdvisor;
    }
}

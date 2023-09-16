package com.example.demo.proxyconfig;

import com.example.demo.proxy.v0.*;
import com.example.demo.threadlocal.log.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppV1Config {

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

}

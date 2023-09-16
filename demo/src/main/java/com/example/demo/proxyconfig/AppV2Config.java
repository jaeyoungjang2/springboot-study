package com.example.demo.proxyconfig;

import com.example.demo.proxy.v1.ProxyLogControllerV1;
import com.example.demo.proxy.v1.ProxyLogRepositoryV1;
import com.example.demo.proxy.v1.ProxyLogServiceV1;
import com.example.demo.threadlocal.log.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppV2Config {

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

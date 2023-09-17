package com.example.demo.proxyconfig.v5_aspect;

import com.example.demo.proxyconfig.v5_aspect.code.AspectAop;
import com.example.demo.threadlocal.log.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
public class AspectConfig {

    @Bean
    public AspectAop aspectAop(LogTrace logTrace) {
        return new AspectAop(logTrace);
    }
}

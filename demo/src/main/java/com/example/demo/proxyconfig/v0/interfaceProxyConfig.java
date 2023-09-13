package com.example.demo.proxyconfig.v0;

import com.example.demo.proxy.v0.*;
import com.example.demo.proxyconfig.v0.interface_proxy.LogControllerInterfaceProxy;
import com.example.demo.proxyconfig.v0.interface_proxy.LogRepositoryInterfaceProxy;
import com.example.demo.proxyconfig.v0.interface_proxy.LogServiceInterfaceProxy;
import com.example.demo.threadlocal.log.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class interfaceProxyConfig {

    @Bean
    public ProxyLogControllerV0 proxyLogControllerV0(LogTrace logTrace) {
        ProxyLogControllerV0Impl proxyLogControllerV0 = new ProxyLogControllerV0Impl(proxyLogServiceV0(logTrace));
        return new LogControllerInterfaceProxy(logTrace, proxyLogControllerV0);
    }

    @Bean
    public ProxyLogServiceV0 proxyLogServiceV0(LogTrace logTrace) {
        ProxyLogServiceV0Impl proxyLogServiceV0 = new ProxyLogServiceV0Impl(proxyLogRepositoryV0(logTrace));
        return new LogServiceInterfaceProxy(logTrace, proxyLogServiceV0);
    }

    @Bean
    public ProxyLogRepositoryV0 proxyLogRepositoryV0(LogTrace logTrace) {
        ProxyLogRepositoryV0Impl proxyLogRepositoryV0 = new ProxyLogRepositoryV0Impl();
        return new LogRepositoryInterfaceProxy(logTrace, proxyLogRepositoryV0);
    }
}

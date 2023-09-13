package com.example.demo.proxyconfig.v0;

import com.example.demo.proxy.v1.ProxyLogControllerV1;
import com.example.demo.proxy.v1.ProxyLogRepositoryV1;
import com.example.demo.proxy.v1.ProxyLogServiceV1;
import com.example.demo.proxyconfig.v0.concrete_proxy.LogControllerConcreteProxy;
import com.example.demo.proxyconfig.v0.concrete_proxy.LogRepositoryConcreteProxy;
import com.example.demo.proxyconfig.v0.concrete_proxy.LogServiceConcreteProxy;
import com.example.demo.proxyconfig.v0.interface_proxy.LogControllerInterfaceProxy;
import com.example.demo.proxyconfig.v0.interface_proxy.LogRepositoryInterfaceProxy;
import com.example.demo.proxyconfig.v0.interface_proxy.LogServiceInterfaceProxy;
import com.example.demo.threadlocal.log.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConcreteProxyConfig {

    @Bean
    public ProxyLogControllerV1 proxyLogControllerV1(LogTrace logTrace) {
        ProxyLogControllerV1 proxyLogControllerV1 = new ProxyLogControllerV1(proxyLogServiceV1(logTrace));
        return new LogControllerConcreteProxy(logTrace, proxyLogControllerV1);

    }

    @Bean
    public ProxyLogServiceV1 proxyLogServiceV1(LogTrace logTrace) {
        ProxyLogServiceV1 proxyLogServiceV1 = new ProxyLogServiceV1(proxyLogRepositoryV1(logTrace));
        return new LogServiceConcreteProxy(logTrace, proxyLogServiceV1);
    }

    @Bean
    public ProxyLogRepositoryV1 proxyLogRepositoryV1(LogTrace logTrace) {
        ProxyLogRepositoryV1 proxyLogRepositoryV1 = new ProxyLogRepositoryV1();
        return new LogRepositoryConcreteProxy(logTrace, proxyLogRepositoryV1);
    }
}

package com.example.demo.proxy;

import com.example.demo.proxy.code.ProxyClient;
import com.example.demo.proxy.code.ProxySubject;
import com.example.demo.proxy.code.RealSubject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProxyPatterTest {

    @Test
    @DisplayName("프록시를 통한 캐시 처리")
    public void noProxyPatternTest() {
        RealSubject realSubject = new RealSubject();
        ProxyClient proxyClient = new ProxyClient(realSubject);
        proxyClient.execute();
        proxyClient.execute();
        proxyClient.execute();
    }


    @Test
    @DisplayName("프록시를 통한 캐시 처리")
    public void proxyPatternTest() {
        RealSubject realSubject = new RealSubject();
        ProxySubject proxySubject = new ProxySubject(realSubject);
        ProxyClient proxyClient = new ProxyClient(proxySubject);
        proxyClient.execute();
        proxyClient.execute();
        proxyClient.execute();
    }
}

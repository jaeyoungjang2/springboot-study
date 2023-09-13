package com.example.demo.proxyconfig.v0.interface_proxy;


import com.example.demo.proxy.v0.ProxyLogRepositoryV0;
import com.example.demo.proxy.v0.ProxyLogServiceV0;
import com.example.demo.threadlocal.log.LogTrace;
import com.example.demo.threadlocal.log.LogTraceStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class LogServiceInterfaceProxy implements ProxyLogServiceV0 {

    private final LogTrace logTrace;
    private final ProxyLogServiceV0 proxyLogServiceV0;

    public void save(String itemId) {
        String message = "LogServiceInterfaceProxy.request";
        LogTraceStatus status = logTrace.begin(message);
        proxyLogServiceV0.save(itemId);
        logTrace.end(status);
    }
}

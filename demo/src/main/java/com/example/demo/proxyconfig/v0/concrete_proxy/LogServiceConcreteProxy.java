package com.example.demo.proxyconfig.v0.concrete_proxy;


import com.example.demo.proxy.v1.ProxyLogServiceV1;
import com.example.demo.threadlocal.log.LogTrace;
import com.example.demo.threadlocal.log.LogTraceStatus;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogServiceConcreteProxy extends ProxyLogServiceV1 {

    public LogServiceConcreteProxy(LogTrace logTrace, ProxyLogServiceV1 proxyLogServiceV1) {
        super(null);
        this.logTrace = logTrace;
        this.proxyLogServiceV1 = proxyLogServiceV1;
    }

    private final LogTrace logTrace;
    private final ProxyLogServiceV1 proxyLogServiceV1;

    public void save(String itemId) {
        String message = "LogServiceConcreteProxy.request";
        LogTraceStatus status = logTrace.begin(message);
        proxyLogServiceV1.save(itemId);
        logTrace.end(status);
    }
}

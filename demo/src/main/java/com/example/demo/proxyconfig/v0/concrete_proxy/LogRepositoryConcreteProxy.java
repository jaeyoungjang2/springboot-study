package com.example.demo.proxyconfig.v0.concrete_proxy;


import com.example.demo.proxy.v1.ProxyLogRepositoryV1;
import com.example.demo.threadlocal.log.LogTrace;
import com.example.demo.threadlocal.log.LogTraceStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class LogRepositoryConcreteProxy extends ProxyLogRepositoryV1 {

    private final LogTrace logTrace;
    private final ProxyLogRepositoryV1 logRepositoryV1;

    public void save(String itemId) {
        String message = "LogRepositoryConcreteProxy.request";
        LogTraceStatus status = logTrace.begin(message);
        logRepositoryV1.save(itemId);
        logTrace.end(status);
    }
}

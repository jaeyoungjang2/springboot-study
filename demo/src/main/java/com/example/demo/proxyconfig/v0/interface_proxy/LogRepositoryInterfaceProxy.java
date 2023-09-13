package com.example.demo.proxyconfig.v0.interface_proxy;


import com.example.demo.proxy.v0.ProxyLogRepositoryV0;
import com.example.demo.threadlocal.log.LogTrace;
import com.example.demo.threadlocal.log.LogTraceStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@RequiredArgsConstructor
public class LogRepositoryInterfaceProxy implements ProxyLogRepositoryV0 {

    private final LogTrace logTrace;
    private final ProxyLogRepositoryV0 logRepositoryV0;

    public void save(String itemId) {
        String message = "LogRepositoryInterfaceProxy.request";
        LogTraceStatus status = logTrace.begin(message);
        logRepositoryV0.save(itemId);
        logTrace.end(status);
    }
}

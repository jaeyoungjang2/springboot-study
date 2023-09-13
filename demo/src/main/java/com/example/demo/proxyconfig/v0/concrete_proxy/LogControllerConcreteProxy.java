package com.example.demo.proxyconfig.v0.concrete_proxy;

import com.example.demo.proxy.v1.ProxyLogControllerV1;
import com.example.demo.threadlocal.log.LogTrace;
import com.example.demo.threadlocal.log.LogTraceStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping("/proxy")
public class LogControllerConcreteProxy extends ProxyLogControllerV1 {

    private final LogTrace logTrace;
    private final ProxyLogControllerV1 proxyLogControllerV1;

    public LogControllerConcreteProxy(LogTrace logTrace, ProxyLogControllerV1 proxyLogControllerV1) {
        super(null);
        this.logTrace = logTrace;
        this.proxyLogControllerV1 = proxyLogControllerV1;
    }

    /**
     * 핵심 로직 (itemId 저장)과 부가 로직 (로그 작성)이 같이 있는 상태
     */

    public void request(@PathVariable String itemId) {
        String message = "LogControllerConcreteProxy.request";
        LogTraceStatus status = logTrace.begin(message);
        proxyLogControllerV1.request(itemId);
        logTrace.end(status);
    }
}

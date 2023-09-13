package com.example.demo.proxyconfig.v0.interface_proxy;

import com.example.demo.proxy.v0.ProxyLogControllerV0;
import com.example.demo.proxy.v0.ProxyLogServiceV0;
import com.example.demo.threadlocal.log.LogTrace;
import com.example.demo.threadlocal.log.LogTraceStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/proxy")
public class LogControllerInterfaceProxy implements ProxyLogControllerV0 {

    private final LogTrace logTrace;
    private final ProxyLogControllerV0 proxyLogControllerV0;

    /**
     * 핵심 로직 (itemId 저장)과 부가 로직 (로그 작성)이 같이 있는 상태
     */
    @GetMapping("/v0/{itemId}")
    public void request(@PathVariable String itemId) {
        String message = "LogControllerInterfaceProxy.request";
        LogTraceStatus status = logTrace.begin(message);
        proxyLogControllerV0.request(itemId);
        logTrace.end(status);
    }
}

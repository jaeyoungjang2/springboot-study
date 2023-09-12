package com.example.demo.proxy.v0;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/proxy")
public class ProxyLogControllerV0Impl implements ProxyLogControllerV0 {

    private final ProxyLogServiceV0 serviceV0;

    /**
     * 핵심 로직 (itemId 저장)과 부가 로직 (로그 작성)이 같이 있는 상태
     */
    @GetMapping("/v0/{itemId}")
    public void request(@PathVariable String itemId) {
        serviceV0.save(itemId);
    }
}

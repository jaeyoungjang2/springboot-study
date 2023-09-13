package com.example.demo.proxy.v1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/proxy")
@ResponseBody
public class ProxyLogControllerV1 {

    private final ProxyLogServiceV1 serviceV1;

    /**
     * 핵심 로직 (itemId 저장)과 부가 로직 (로그 작성)이 같이 있는 상태
     */
    @GetMapping("/v1/{itemId}")
    public void request(@PathVariable String itemId) {
        serviceV1.save(itemId);
    }
}

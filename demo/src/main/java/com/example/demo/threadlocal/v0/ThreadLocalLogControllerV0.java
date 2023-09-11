package com.example.demo.threadlocal.v0;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/threadlocal")
public class ThreadLocalLogControllerV0 {

    private final ThreadLocalLogServiceV0 serviceV0;

    /**
     * 핵심 로직 (itemId 저장)과 부가 로직 (로그 작성)이 같이 있는 상태
     */
    @GetMapping("/v0/{itemId}")
    public void request(@PathVariable String itemId) {
        String uuId = UUID.randomUUID().toString().substring(0, 8);
        String message = "ThreadLocalLogControllerV0.save";
        long startTime = System.currentTimeMillis();
        log.info("[{}] start {}", uuId, message);
        serviceV0.save(itemId);
        long endTime = System.currentTimeMillis();
        log.info("[{}] end {} startTime={} endTime={}", uuId, message, startTime, endTime);
    }
}

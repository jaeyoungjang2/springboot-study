package com.example.demo.threadlocal.v0;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ThreadLocalLogServiceV0 {

    private final ThreadLocalLogRepositoryV0 repositoryV0;
    public void save(String itemId) {
        String uuId = UUID.randomUUID().toString().substring(0, 8);
        String message = "ThreadLocalLogServiceV0.save";
        long startTime = System.currentTimeMillis();
        log.info("[{}] start {}", uuId, message);
        repositoryV0.save(itemId);
        long endTime = System.currentTimeMillis();
        log.info("[{}] end {} startTime={} endTime={}", uuId, message, startTime, endTime);
    }
}

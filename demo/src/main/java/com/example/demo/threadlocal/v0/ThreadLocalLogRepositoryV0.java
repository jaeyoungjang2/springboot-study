package com.example.demo.threadlocal.v0;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Slf4j
@Repository
public class ThreadLocalLogRepositoryV0 {

    public void save(String itemId) {
        String uuId = UUID.randomUUID().toString().substring(0, 8);
        String message = "ThreadLocalLogRepositoryV0.save";
        long startTime = System.currentTimeMillis();
        log.info("[{}] start {}", uuId, message);
        this.sleep(1000);
        long endTime = System.currentTimeMillis();
        log.info("[{}] end {} startTime={} endTime={}", uuId, message, startTime, endTime);
    }

    private void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            log.info("exception");
        }

    }
}

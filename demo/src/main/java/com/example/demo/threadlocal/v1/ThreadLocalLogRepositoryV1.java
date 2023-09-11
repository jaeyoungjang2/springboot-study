package com.example.demo.threadlocal.v1;


import com.example.demo.threadlocal.log.LogTrace;
import com.example.demo.threadlocal.log.LogTraceStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ThreadLocalLogRepositoryV1 {

    private final LogTrace logTrace;
    public void save(String itemId) {
        String message = "ThreadLocalLogServiceV1.save";
        LogTraceStatus status = logTrace.begin(message);
        this.sleep(1000);
        logTrace.end(status);
    }

    private void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            log.info("exception");
        }

    }
}

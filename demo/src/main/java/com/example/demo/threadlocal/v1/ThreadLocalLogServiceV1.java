package com.example.demo.threadlocal.v1;


import com.example.demo.threadlocal.log.LogTrace;
import com.example.demo.threadlocal.log.LogTraceStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ThreadLocalLogServiceV1 {

    private final ThreadLocalLogRepositoryV1 repositoryV0;
    private final LogTrace logTrace;
    public void save(String itemId) {
        String message = "ThreadLocalLogServiceV1.save";
        LogTraceStatus status = logTrace.begin(message);
        repositoryV0.save(itemId);
        logTrace.end(status);
    }
}

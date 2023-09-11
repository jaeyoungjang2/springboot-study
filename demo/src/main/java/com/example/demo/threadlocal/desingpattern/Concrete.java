package com.example.demo.threadlocal.desingpattern;

import com.example.demo.threadlocal.log.LogTrace;
import com.example.demo.threadlocal.log.LogTraceStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class Concrete {

    private final LogTrace logTrace;
    public void execute(String message, Strategy strategy) {
        LogTraceStatus status = logTrace.begin(message);
        strategy.call();
        logTrace.end(status);
    }
}

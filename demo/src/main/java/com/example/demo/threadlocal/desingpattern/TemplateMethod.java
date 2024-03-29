package com.example.demo.threadlocal.desingpattern;

import com.example.demo.threadlocal.log.LogTrace;
import com.example.demo.threadlocal.log.LogTraceStatus;
import com.example.demo.threadlocal.log.TraceInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
public abstract class TemplateMethod {

    private final LogTrace logTrace;
    public void execute(String message) {
        LogTraceStatus status = logTrace.begin(message);
        call();
        logTrace.end(status);
    }

    abstract public void call();
}

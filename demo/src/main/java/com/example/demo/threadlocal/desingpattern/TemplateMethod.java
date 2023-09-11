package com.example.demo.threadlocal.desingpattern;

import com.example.demo.threadlocal.log.LogTraceStatus;
import com.example.demo.threadlocal.log.TraceInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public abstract class TemplateMethod {

    private TraceInfo traceInfo;
    public void execute(String message) {
        if (traceInfo == null) {
            String uuId = UUID.randomUUID().toString().substring(0, 8);
            traceInfo = new TraceInfo(uuId, 0);
        }
        String uuId = traceInfo.getUuId();
        traceInfo.nextLevel();
        long startTime = System.currentTimeMillis();
        log.info("[{}] start {}", uuId, message);
        LogTraceStatus status = new LogTraceStatus(uuId, startTime, message);

        call();

        long endTime = System.currentTimeMillis();
        log.info("[{}] end {} startTime={} endTime={}", status.getUuId(), status.getMessage(), status.getStartTime(), endTime);
        traceInfo.previouseLevel();
        if (traceInfo.isLastLevel()) {
            traceInfo = null;
        }
    }

    abstract public void call();
}

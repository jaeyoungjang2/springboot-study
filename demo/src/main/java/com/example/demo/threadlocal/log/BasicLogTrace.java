package com.example.demo.threadlocal.log;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class BasicLogTrace implements LogTrace {

    private TraceInfo traceInfo;
    @Override
    public LogTraceStatus begin(String message) {
        if (traceInfo == null) {
            String uuId = UUID.randomUUID().toString().substring(0, 8);
            traceInfo = new TraceInfo(uuId, 0);
        }
        String uuId = traceInfo.getUuId();
        traceInfo.nextLevel();
        long startTime = System.currentTimeMillis();
        log.info("[{}] start {}", uuId, message);
        return new LogTraceStatus(uuId, startTime, message);
    }

    @Override
    public void end(LogTraceStatus status) {
        long endTime = System.currentTimeMillis();
        log.info("[{}] end {} startTime={} endTime={}", status.getUuId(), status.getMessage(), status.getStartTime(), endTime);
        traceInfo.previouseLevel();
        if (traceInfo.isLastLevel()) {
            traceInfo = null;
        }
    }
}

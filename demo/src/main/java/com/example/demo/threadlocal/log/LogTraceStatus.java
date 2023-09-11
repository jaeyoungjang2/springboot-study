package com.example.demo.threadlocal.log;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class LogTraceStatus {

    private final String uuId;
    private final long startTime;
    private final String message;
}

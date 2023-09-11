package com.example.demo.threadlocal.log;

public interface LogTrace {
    LogTraceStatus begin(String message);

    void end(LogTraceStatus stats);
}

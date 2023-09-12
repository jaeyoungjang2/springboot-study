package com.example.demo.proxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProxySubject implements Subject {

    private Subject target;
    private String cache;

    public ProxySubject(Subject target) {
        this.target = target;
    }

    @Override
    public String call() {
        if (cache == null) {
            cache = target.call();
            return String.format("proxy subject -> %s", cache);
        }
        log.info("{}", cache);
        return String.format("proxy subject -> %s", cache);
    }
}


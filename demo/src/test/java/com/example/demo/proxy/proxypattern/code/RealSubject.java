package com.example.demo.proxy.proxypattern.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealSubject implements Subject {
    @Override
    public String call() {
        this.sleep(1000);
        log.info("realSubject");
        return "realSubject";
    }

    private void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            System.out.println("exception");
        }
    }
}

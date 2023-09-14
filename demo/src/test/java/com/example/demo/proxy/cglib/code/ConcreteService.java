package com.example.demo.proxy.cglib.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteService {
    public void call() {
        log.info("call concrete service");
    }
}

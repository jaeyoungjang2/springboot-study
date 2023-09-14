package com.example.demo.proxy.jdkdynamic.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AImpl implements AInterface {
    @Override
    public void call() {
        log.info("call AImpl");
    }
}

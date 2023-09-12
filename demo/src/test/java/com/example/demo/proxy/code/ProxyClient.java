package com.example.demo.proxy.code;

import lombok.extern.slf4j.Slf4j;

public class ProxyClient {

    private Subject target;

    public ProxyClient(Subject target) {
        this.target = target;
    }

    public String execute() {
        return target.call();
    }
}

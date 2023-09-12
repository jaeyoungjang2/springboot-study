package com.example.demo.proxy.proxypattern.code;

public class ProxyClient {

    private Subject target;

    public ProxyClient(Subject target) {
        this.target = target;
    }

    public String execute() {
        return target.call();
    }
}

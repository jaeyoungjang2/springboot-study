package com.example.demo.proxy.decoratorpattern.code;

public class DecoratorClient {

    private Component target;

    public DecoratorClient(Component target) {
        this.target = target;
    }

    public String execute() {
        return target.operation();
    }
}

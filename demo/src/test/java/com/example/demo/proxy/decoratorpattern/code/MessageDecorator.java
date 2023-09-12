package com.example.demo.proxy.decoratorpattern.code;

public class MessageDecorator implements Component {

    private Component target;

    public MessageDecorator(Component target) {
        this.target = target;
    }

    @Override
    public String operation() {
        return String.format("%s **Decorator**", target.operation());
    }
}

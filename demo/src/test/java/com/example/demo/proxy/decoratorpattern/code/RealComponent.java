package com.example.demo.proxy.decoratorpattern.code;

public class RealComponent implements Component {

    @Override
    public String operation() {
        return "realComponent";
    }
}

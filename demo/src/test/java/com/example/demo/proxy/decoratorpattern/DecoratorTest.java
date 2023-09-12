package com.example.demo.proxy.decoratorpattern;

import com.example.demo.proxy.decoratorpattern.code.DecoratorClient;
import com.example.demo.proxy.decoratorpattern.code.MessageDecorator;
import com.example.demo.proxy.decoratorpattern.code.RealComponent;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class DecoratorTest {

    @Test
    public void DecoratorTest() {
        RealComponent realComponent = new RealComponent();
        MessageDecorator messageDecorator = new MessageDecorator(realComponent);
        DecoratorClient decoratorClient = new DecoratorClient(messageDecorator);
        String execute = decoratorClient.execute();
        log.info(execute);

    }
}

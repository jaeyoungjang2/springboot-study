package com.example.demo.proxy.cglib;

import com.example.demo.proxy.cglib.code.ConcreteService;
import com.example.demo.proxy.cglib.code.TimeMethodInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

@Slf4j
public class CglibTest {

    @Test
    public void CglibTest() {
        ConcreteService concreteService = new ConcreteService();
        TimeMethodInterceptor timeMethodInterceptor = new TimeMethodInterceptor(concreteService);

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ConcreteService.class);
        enhancer.setCallback(timeMethodInterceptor);
        ConcreteService proxy = (ConcreteService) enhancer.create();
        proxy.call();

        log.info("{}", concreteService.getClass());
        log.info("{}", proxy.getClass());
    }
}

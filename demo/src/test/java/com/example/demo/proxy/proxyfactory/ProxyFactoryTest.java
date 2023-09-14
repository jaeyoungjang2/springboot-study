package com.example.demo.proxy.proxyfactory;

import com.example.demo.proxy.cglib.code.ConcreteService;
import com.example.demo.proxy.cglib.code.ServiceImpl;
import com.example.demo.proxy.cglib.code.ServiceInterface;
import com.example.demo.proxy.proxyfactory.code.ProxyFactoryAdvice;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;

@Slf4j
public class ProxyFactoryTest {

    @Test
    @DisplayName("구체 클래스에는 cglib 사용")
    public void ProxyFactoryTest1() {

        ConcreteService concreteService = new ConcreteService();
        ProxyFactoryAdvice proxyFactoryAdvice = new ProxyFactoryAdvice();

        ProxyFactory proxyFactory = new ProxyFactory(concreteService);
        proxyFactory.addAdvice(proxyFactoryAdvice);
        ConcreteService proxy = (ConcreteService) proxyFactory.getProxy();
        proxy.call();

        log.info("{}", proxy.getClass());
    }

    @Test
    @DisplayName("인터페이스에는 JDKlib 사용")
    public void ProxyFactoryTest2() {

        ServiceImpl service = new ServiceImpl();
        ProxyFactoryAdvice proxyFactoryAdvice = new ProxyFactoryAdvice();

        ProxyFactory proxyFactory = new ProxyFactory(service);
        proxyFactory.addAdvice(proxyFactoryAdvice);
        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();
        proxy.call();

        log.info("{}", proxy.getClass());
    }


}

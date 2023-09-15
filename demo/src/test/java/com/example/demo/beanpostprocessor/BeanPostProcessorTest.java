package com.example.demo.beanpostprocessor;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Slf4j
public class BeanPostProcessorTest {
    
    
    @Test
    public void BeanPostProcessorTest1() {
        AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext(BeanPostProcessorConfig.class);
//        BeanA beanA = (BeanA) config.getBean("beanA");
//        beanA.call();

        BeanB beanB = (BeanB) config.getBean("beanA");
        beanB.call();
    }

    static class AToBPostProcessor implements BeanPostProcessor {
        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
            return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
        }

        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            if (bean instanceof BeanA) {
                return new BeanB();
            }
            return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
        }
    }


    static class BeanPostProcessorConfig {
        @Bean
        public BeanA beanA() {
            return new BeanA();
        }

        @Bean
        public AToBPostProcessor aToBPostProcessor() {
            return new AToBPostProcessor();
        }
    }
    
    static class BeanA {
        public void call() {
            log.info("call beanA");
        }
    }
    
    static class BeanB {
        public void call() {
            log.info("call beanB");
        }
    }
}

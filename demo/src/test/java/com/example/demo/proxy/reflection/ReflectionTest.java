package com.example.demo.proxy.reflection;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class ReflectionTest {

    @Test
    public void ReflectionTestV0() {
        Hello hello = new Hello();
        hello.callA();
        hello.callB();
    }

    @Test
    public void ReflectionTestV2() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Hello hello = new Hello();

        Class classHello = Class.forName("com.example.demo.proxy.reflection.ReflectionTest$Hello");
        Method callA = classHello.getMethod("callA");
        callA.invoke(hello);


        Method callB = classHello.getMethod("callB");
        callB.invoke(hello);
    }

    @Test
    public void ReflectionTest() throws Exception {
        Hello hello = new Hello();

        Class classHello = Class.forName("com.example.demo.proxy.reflection.ReflectionTest$Hello");
        Method callA = classHello.getMethod("callA");
        extracted(hello, callA);


        Method callB = classHello.getMethod("callB");
        extracted(hello, callB);
    }

    private static void extracted(Hello hello, Method callA) throws IllegalAccessException, InvocationTargetException {
        callA.invoke(hello);
    }

    public static class Hello {
        public void callA() {
            log.info("callA");
        }

        public void callB() {
            log.info("callB");
        }
    }

}

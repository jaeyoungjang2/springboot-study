package com.example.demo.proxy.jdkdynamic;

import com.example.demo.proxy.jdkdynamic.code.AImpl;
import com.example.demo.proxy.jdkdynamic.code.AInterface;
import com.example.demo.proxy.jdkdynamic.code.TimeInvocationHandler;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

public class JdkDynamicTest {
    @Test
    public void JdkDynamicTest() {
        AImpl a = new AImpl();
        TimeInvocationHandler timeInvocationHandler = new TimeInvocationHandler(a);
        AInterface aimpl = (AInterface) Proxy.newProxyInstance(AInterface.class.getClassLoader(), new Class[]{AInterface.class}, timeInvocationHandler);
        aimpl.call();
    }
}

package com.example.demo;

import com.example.demo.proxyconfig.AppV1Config;
import com.example.demo.proxyconfig.AppV2Config;
import com.example.demo.proxyconfig.v0.ConcreteProxyConfig;
import com.example.demo.proxyconfig.v0.InterfaceProxyConfig;
import com.example.demo.proxyconfig.v1_dynamicproxy.JdkDynamicProxyConfig;
import com.example.demo.proxyconfig.v2_proxyfactory.ProxyFactoryConfig;
import com.example.demo.proxyconfig.v3_beanpostprocessor.BeanPostProcessorConfig;
import com.example.demo.proxyconfig.v4_autoproxy.AutoProxyConfig;
import com.example.demo.threadlocal.log.BasicLogTrace;
import com.example.demo.threadlocal.log.LogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import({InterfaceProxyConfig.class, ConcreteProxyConfig.class})
//@Import({JdkDynamicProxyConfig.class})
//@Import(ProxyFactoryConfig.class)
//@Import({BeanPostProcessorConfig.class})
@Import({AppV1Config.class, AppV2Config.class, AutoProxyConfig.class})
@SpringBootApplication(scanBasePackages = "com.example.demo.proxy")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public LogTrace logTrace() {
		return new BasicLogTrace();
	}
}



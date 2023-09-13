package com.example.demo;

import com.example.demo.proxyconfig.v0.interfaceProxyConfig;
import com.example.demo.threadlocal.log.BasicLogTrace;
import com.example.demo.threadlocal.log.LogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import(interfaceProxyConfig.class)
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



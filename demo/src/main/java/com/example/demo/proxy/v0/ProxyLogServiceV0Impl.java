package com.example.demo.proxy.v0;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
public class ProxyLogServiceV0Impl implements ProxyLogServiceV0 {

    private final ProxyLogRepositoryV0 repositoryV0;
    public void save(String itemId) {
        repositoryV0.save(itemId);
    }
}

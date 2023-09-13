package com.example.demo.proxy.v1;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class ProxyLogServiceV1 {

    private final ProxyLogRepositoryV1 repositoryV1;

    public void save(String itemId) {
        repositoryV1.save(itemId);
    }
}

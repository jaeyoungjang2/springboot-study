package com.example.demo.proxy.v1;


import com.example.demo.proxy.v0.ProxyLogRepositoryV0;
import com.example.demo.proxy.v0.ProxyLogServiceV0;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class ProxyLogServiceV1 {

    private final ProxyLogRepositoryV0 repositoryV0;

    public void save(String itemId) {
        repositoryV0.save(itemId);
    }
}

package com.example.demo.proxy.v0;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class ProxyLogRepositoryV0Impl implements ProxyLogRepositoryV0 {

    public void save(String itemId) {
        this.sleep(1000);
    }

    private void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            log.info("exception");
        }

    }
}

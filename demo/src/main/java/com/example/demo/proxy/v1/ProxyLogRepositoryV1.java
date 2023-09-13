package com.example.demo.proxy.v1;


import com.example.demo.proxy.v0.ProxyLogRepositoryV0;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
public class ProxyLogRepositoryV1 {

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

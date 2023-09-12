package com.example.demo.proxy.v0;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.UUID;


public interface ProxyLogRepositoryV0 {

    public void save(String itemId);
}

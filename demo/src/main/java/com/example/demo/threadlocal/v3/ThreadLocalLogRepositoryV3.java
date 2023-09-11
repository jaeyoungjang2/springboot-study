package com.example.demo.threadlocal.v3;


import com.example.demo.threadlocal.desingpattern.Concrete;
import com.example.demo.threadlocal.desingpattern.TemplateMethod;
import com.example.demo.threadlocal.log.LogTrace;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ThreadLocalLogRepositoryV3 {

    private final LogTrace logTrace;
    private final Concrete concrete;
    public void save(String itemId) {
        String message = "ThreadLocalLogServiceV3.save";
        concrete.execute(message, () -> sleep(1000));
    }

    private void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            log.info("exception");
        }

    }
}

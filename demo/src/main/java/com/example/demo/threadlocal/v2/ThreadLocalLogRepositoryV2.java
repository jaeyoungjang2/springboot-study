package com.example.demo.threadlocal.v2;


import com.example.demo.threadlocal.desingpattern.TemplateMethod;
import com.example.demo.threadlocal.log.LogTrace;
import com.example.demo.threadlocal.log.LogTraceStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ThreadLocalLogRepositoryV2 {

    private final LogTrace logTrace;
    public void save(String itemId) {
        String message = "ThreadLocalLogServiceV2.save";
        TemplateMethod templateMethod = new TemplateMethod() {
            @Override
            public void call() {
                sleep(1000);
            }
        };

        templateMethod.execute(message);
    }

    private void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            log.info("exception");
        }

    }
}

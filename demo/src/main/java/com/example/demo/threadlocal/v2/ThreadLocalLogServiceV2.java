package com.example.demo.threadlocal.v2;


import com.example.demo.threadlocal.desingpattern.TemplateMethod;
import com.example.demo.threadlocal.log.LogTrace;
import com.example.demo.threadlocal.log.LogTraceStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ThreadLocalLogServiceV2 {

    private final ThreadLocalLogRepositoryV2 repositoryV0;
    private final LogTrace logTrace;
    public void save(String itemId) {
        String message = "ThreadLocalLogServiceV2.save";

        TemplateMethod templateMethod = new TemplateMethod() {
            @Override
            public void call() {
                repositoryV0.save(itemId);
            }
        };

        templateMethod.execute(message);
    }
}

package com.example.demo.threadlocal.v3;


import com.example.demo.threadlocal.desingpattern.Concrete;
import com.example.demo.threadlocal.desingpattern.TemplateMethod;
import com.example.demo.threadlocal.log.LogTrace;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ThreadLocalLogServiceV3 {

    private final ThreadLocalLogRepositoryV3 repositoryV0;
    private final Concrete concrete;
    public void save(String itemId) {
        String message = "ThreadLocalLogServiceV3.save";
        concrete.execute(message, () -> repositoryV0.save(itemId));
    }
}

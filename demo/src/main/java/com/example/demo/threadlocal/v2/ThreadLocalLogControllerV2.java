package com.example.demo.threadlocal.v2;

import com.example.demo.threadlocal.desingpattern.TemplateMethod;
import com.example.demo.threadlocal.log.LogTrace;
import com.example.demo.threadlocal.log.LogTraceStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/threadlocal")
public class ThreadLocalLogControllerV2 {

    private final ThreadLocalLogServiceV2 serviceV0;
    private final LogTrace logTrace;

    /**
     * 핵심 로직 (itemId 저장)과 부가 로직 (로그 작성)이 같이 있는 상태
     */
    @GetMapping("/v2/{itemId}")
    public void request(@PathVariable String itemId) {
        String message = "ThreadLocalLogControllerV2.save";
        TemplateMethod templateMethod = new TemplateMethod() {
            @Override
            public void call() {
                serviceV0.save(itemId);
            }
        };

        templateMethod.execute(message);
    }
}

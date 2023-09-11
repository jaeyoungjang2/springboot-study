package com.example.demo.threadlocal.v3;

import com.example.demo.threadlocal.desingpattern.Concrete;
import com.example.demo.threadlocal.desingpattern.TemplateMethod;
import com.example.demo.threadlocal.log.LogTrace;
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
public class ThreadLocalLogControllerV3 {

    private final ThreadLocalLogServiceV3 serviceV0;
    private final Concrete concrete;

    /**
     * 핵심 로직 (itemId 저장)과 부가 로직 (로그 작성)이 같이 있는 상태
     */
    @GetMapping("/v3/{itemId}")
    public void request(@PathVariable String itemId) {
        String message = "ThreadLocalLogControllerV3.save";
        concrete.execute(message, () -> serviceV0.save(itemId));
    }
}

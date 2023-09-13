package com.example.demo.proxy.v0;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@RequestMapping("/proxy")
@ResponseBody
public interface ProxyLogControllerV0 {

    @GetMapping("/v0/{itemId}")
    public void request(@PathVariable String itemId);
}

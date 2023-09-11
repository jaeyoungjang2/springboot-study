package com.example.demo.threadlocal.log;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class TraceInfo {
    private String uuId;
    private Integer level;

    public TraceInfo(String uuId, Integer level) {
        this.uuId = uuId;
        this.level = level;
    }

    public void nextLevel() {
        this.level += 1;
    }

    public void previouseLevel() {
        this.level -= 1;
    }

    public boolean isLastLevel() {
        return this.level.equals(0);
    }
}

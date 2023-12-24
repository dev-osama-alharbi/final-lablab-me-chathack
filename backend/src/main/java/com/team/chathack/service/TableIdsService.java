package com.team.chathack.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TableIdsService {
    private final HashOperations<String, String, Long> valueOps;

    private String KEY = "IDS";

    private String TABLE_MSG = "msg";
    private String TABLE_COMPONENT = "component";
    private String TABLE_ITEM = "item";

    public synchronized long newMsgId() {
        return valueOps.increment(KEY,TABLE_MSG,1);
    }

    public synchronized long newComponentId() {
        return valueOps.increment(KEY,TABLE_COMPONENT,1);
    }

    public synchronized long newItemId() {
        return valueOps.increment(KEY,TABLE_ITEM,1);
    }
}

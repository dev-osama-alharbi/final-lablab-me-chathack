package com.team.chathack.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@RedisHash(value = "table-ids",timeToLive = -1L)
public class TableIds {
//    @Id
    private int id;
    private long msg;
}

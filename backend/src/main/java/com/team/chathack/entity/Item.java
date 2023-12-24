package com.team.chathack.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value = "item")
public class Item {
    @Id
    private Long id;
    @TimeToLive
    private Long timeToLive = -1L;
    @Indexed
    private Long msgId;
    @Indexed
    private Long projectId;
    private String msg;
    @Indexed
    private Long componentId;

}
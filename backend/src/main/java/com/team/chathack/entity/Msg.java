package com.team.chathack.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value = "msg")
public class Msg implements Serializable {
    @Id
    private Long id;
    @TimeToLive
    private Long timeToLive = -1L;
    private String msg;
    private LocalDateTime dateTime;
    private long projectId;
    private long memberId;
}

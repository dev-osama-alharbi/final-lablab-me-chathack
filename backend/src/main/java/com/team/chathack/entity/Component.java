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
@RedisHash(value = "component")
public class Component {
    @Id
    private Long id;
    @TimeToLive
    private Long timeToLive = -1L;

//    private Integer sort;

    @Indexed
    private ComponentType componentType;

    @Indexed
    private Long projectId;
    @Indexed
    private Long msgId;
    private String msg;
    private String title;

    public enum ComponentType{
        DB("DB"),DES("DES");
        private String type;
        ComponentType(String type){
            this.type = type;
        }
        @Override
        public String toString() {
            return type;
        }
    }
}
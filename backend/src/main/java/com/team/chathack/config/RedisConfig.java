package com.team.chathack.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
@RequiredArgsConstructor
public class RedisConfig {
//    private final RedisConnectionFactory redisConnectionFactory;


    @Primary
    @Bean(name = "redis1ConnectionFactory")
    public RedisConnectionFactory redis1ConnectionFactory() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(
                "redis", 6379);
        return new JedisConnectionFactory(config);
    }
//    @Bean
//    public ReactiveRedisConnectionFactory redisConnectionFactory() {
//        return new LettuceConnectionFactory();
//    }


//    @Bean(name = "redis1StringRedisTemplate")
//    public StringRedisTemplate userStringRedisTemplate(@Qualifier("redis1ConnectionFactory") RedisConnectionFactory cf) {
//        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
//        stringRedisTemplate.setConnectionFactory(cf);
//        return stringRedisTemplate;
//    }

//    @Bean(name = "redis1RedisTemplate")
//    public RedisTemplate userRedisTemplate(@Qualifier("redis1ConnectionFactory") RedisConnectionFactory cf) {
//        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
//        stringRedisTemplate.setConnectionFactory(cf);
//        //setSerializer(stringRedisTemplate);
//        return stringRedisTemplate;
//    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redis1ConnectionFactory());
        redisTemplate.setEnableTransactionSupport(true);
        return redisTemplate;
    }
    @Bean
    public StringRedisTemplate stringRedisTemplate() {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate(redis1ConnectionFactory());
        stringRedisTemplate.setEnableTransactionSupport(true);
        return stringRedisTemplate;
    }
    @Bean
    public HashOperations<String, String, Long> valueOperations() {
        return stringRedisTemplate().opsForHash();
    }
}

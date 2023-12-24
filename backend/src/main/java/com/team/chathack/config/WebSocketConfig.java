package com.team.chathack.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // ws://ws.test.osama-alharbi.sa/ws
        // wss://ws.test.osama-alharbi.sa/ws

//        registry.addEndpoint("/ws").setAllowedOriginPatterns("*");
//        registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();
        registry.addEndpoint("/ws").setAllowedOriginPatterns("http://lablabf").withSockJS();
//        registry.addEndpoint("/ws").setAllowedOriginPatterns("http://localhost:4200").withSockJS();

    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(1);
        threadPoolTaskScheduler.setThreadNamePrefix("wss-heartbeat-thread-");
        threadPoolTaskScheduler.initialize();

        registry
                .enableSimpleBroker("/topic")
                .setTaskScheduler(threadPoolTaskScheduler)
                .setHeartbeatValue(new long[]{10000,10000});

    }


}

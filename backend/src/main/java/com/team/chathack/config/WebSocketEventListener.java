package com.team.chathack.config;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

@Component
public class WebSocketEventListener {
    @EventListener
    private void handleSessionConnected(SessionConnectEvent event) {
        System.out.println("SessionConnectEvent >>>>");
    }

    @EventListener
    private void handleSessionDisconnect(SessionDisconnectEvent event) {
        System.out.println("<<<< SessionDisconnectEvent");
    }

    @EventListener
    private void sub(SessionSubscribeEvent event) {
        System.out.println("<<<< SessionSubscribeEvent >>>>");
        System.out.println(event.toString());
    }
}

package com.team.chathack.config;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class ScheduledWs {

    private final SimpMessagingTemplate simpMessagingTemplate;

//    @Scheduled(cron = "*/2 * * * * *")
//    public void scheduledMethod() {
//        simpMessagingTemplate.convertAndSend("/topic/chat.1.lsn.add_tag","add msg "+LocalDateTime.now());
//        System.out.println("* 0 0 ? * * *");
//    }
}

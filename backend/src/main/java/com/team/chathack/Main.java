package com.team.chathack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableFeignClients(basePackages = {"com.team.chathack.feign"})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}

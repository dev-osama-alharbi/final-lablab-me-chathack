package com.team.chathack.controller.rest;

import com.team.chathack.service.ChatListenerWsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public record UsersController(ChatListenerWsService chatListenerWsService) {

    @PostMapping("/aproject/{project_id}/msg/login-user")
    public ResponseEntity<Boolean> getAllUsers(@PathVariable("project_id") int projectId, @RequestBody() String name){
//        chatListenerWsService.loginUser(1);
        System.out.println("+++++++++++++++++++++++ loginUser");
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }


    @PostMapping("/zproject/{project_id}/msg/login-user")
    public ResponseEntity<Boolean> loginUser(@PathVariable("project_id") int projectId, @RequestBody() String name){
//        chatListenerWsService.loginUser(1);
        System.out.println("+++++++++++++++++++++++ loginUser");
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostMapping("/sproject/{project_id}/msg/logout-user")
    public ResponseEntity<Boolean> logoutUser(@PathVariable("project_id") int projectId,@RequestBody() String name){
//        chatListenerWsService.logoutUser(1);
        System.out.println("+++++++++++++++++++++++ logoutUser");
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }
}

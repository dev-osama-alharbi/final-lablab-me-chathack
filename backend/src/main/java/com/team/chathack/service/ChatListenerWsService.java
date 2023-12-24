package com.team.chathack.service;

import com.team.chathack.dto.messages.MsgDTO;
import com.team.chathack.dto.response.ApiResponse;
import com.team.chathack.dto.tags.ComponentDTO;
import com.team.chathack.dto.tags.ItemDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatListenerWsService {

    private final SimpMessagingTemplate simpMessagingTemplate;
    private int count = 1;

    public void addMsg(long projectId, ApiResponse<MsgDTO> body){
        simpMessagingTemplate.convertAndSend("/topic/chat."+projectId+".lsn",body);
    }

    public void addNewTagComponent(long projectId,ApiResponse<ComponentDTO> body){
        simpMessagingTemplate.convertAndSend("/topic/chat."+projectId+".lsn",body);
    }

    public void addNewTagItem(long projectId,ApiResponse<ItemDTO> body){
        simpMessagingTemplate.convertAndSend("/topic/chat."+projectId+".lsn",body);
    }
//
//    public void editTag(int projectId){
//        simpMessagingTemplate.convertAndSend("/topic/chat."+projectId+".lsn.edit_tag","editTag "+getCounter());
//    }
//
//    public void deleteTag(int projectId){
//        simpMessagingTemplate.convertAndSend("/topic/chat."+projectId+".lsn.delete_tag","deleteTag "+getCounter());
//    }
//
//    public void loginUser(int projectId){
//        simpMessagingTemplate.convertAndSend("/topic/chat."+projectId+".lsn.login_user","loginUser "+getCounter());
//    }
//
//    public void logoutUser(int projectId){
//        simpMessagingTemplate.convertAndSend("/topic/chat."+projectId+".lsn.logout_user","logoutUser "+getCounter());
//    }

    private synchronized int getCounter(){
        return count++;
    }
}

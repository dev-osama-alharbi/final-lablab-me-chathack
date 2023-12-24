package com.team.chathack.service;

import com.team.chathack.dto.messages.MsgDTO;
import com.team.chathack.dto.messages.NewMsgDTO;
import com.team.chathack.dto.response.ApiResponse;
import com.team.chathack.entity.Msg;
import com.team.chathack.mapper.EntityMapper;
import com.team.chathack.repo.MsgRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class MsgService {
    private final MsgRepo msgRepo;
    private final TableIdsService tableIdsService;
    private final ChatListenerWsService chatListenerWsService;
//    private final EntityMapper entityMapper;

    public boolean addNewMsg(NewMsgDTO newMsgDTO) {

        Msg msg = Msg
                .builder()
                .id(tableIdsService.newMsgId())
                .msg(newMsgDTO.getMsg())
                .dateTime(LocalDateTime.now())
                .memberId(newMsgDTO.getMemberId())
                .projectId(newMsgDTO.getProjectId())
                .timeToLive(-0L)
                .build();
        Msg newMsg = msgRepo.save(msg);

        /*

    private Long id;
    private String msg;
    private LocalDateTime dateTime;
    private long projectId;
    private long memberId;
         */

        MsgDTO msgDTO = MsgDTO
                .builder()
                .id(newMsg.getId())
                .msg(newMsg.getMsg())
                .dateTime(newMsg.getDateTime())
                .projectId(newMsg.getProjectId())
                .memberId(newMsg.getMemberId())
                .build();

        ApiResponse<MsgDTO> apiResponse = ApiResponse.<MsgDTO>builder()
                .body(msgDTO)
                .type(ApiResponse.ApiResponseType.MSG_NEW)
                .httpCode(HttpStatus.OK.value())
                .build();
        chatListenerWsService.addMsg(newMsg.getProjectId(),apiResponse);

        return newMsg != null;
    }

    public List<Msg> getAllMsg(long projectId) {
        Iterable<Msg> iterable = msgRepo.findAll();
        List<Msg> lst = new ArrayList<>();
        iterable.forEach(msg -> {
            if(msg != null){
                lst.add(msg);
            }
        });
        return lst;
    }

    public Msg getMsgById(Long msgId) {
        return msgRepo.findById(msgId).orElse(null);
    }
}

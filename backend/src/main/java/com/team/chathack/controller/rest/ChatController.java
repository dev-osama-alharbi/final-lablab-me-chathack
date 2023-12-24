package com.team.chathack.controller.rest;

import com.team.chathack.dto.messages.MsgDTO;
import com.team.chathack.dto.messages.NewMsgDTO;
import com.team.chathack.dto.response.ApiResponse;
import com.team.chathack.entity.Msg;
import com.team.chathack.mapper.EntityMapper;
import com.team.chathack.service.MsgService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("api/v1/chat")
@RequiredArgsConstructor
public class ChatController {
    private final MsgService msgService;


    @GetMapping("/project/{project_id}/msg")
    public ResponseEntity<ApiResponse<List<MsgDTO>>> getAll(@PathVariable("project_id") long projectId){
        List<Msg> lst = msgService.getAllMsg(projectId);
        if(lst == null || lst.size() <= 0){
            ApiResponse<List<MsgDTO>> apiResponse = ApiResponse.<List<MsgDTO>>builder()
                    .body(new ArrayList<MsgDTO>())
                    .hasErrors(true)
                    .httpCode(HttpStatus.NO_CONTENT.value())
                    .build();

            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body(apiResponse);
        }

        ApiResponse<List<MsgDTO>> apiResponse = ApiResponse.<List<MsgDTO>>builder()
                .body(lst.stream().map(msg -> MsgDTO
                        .builder()
                        .id(msg.getId())
                        .msg(msg.getMsg())
                        .dateTime(msg.getDateTime())
                        .projectId(msg.getProjectId())
                        .memberId(msg.getMemberId())
                        .build()).toList())
                .type(ApiResponse.ApiResponseType.MSG_ALL)
                .hasErrors(false)
                .httpCode(HttpStatus.OK.value())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

//    @PostMapping("/project/{project_id}/msg/page/{page_id}")
//    public ResponseEntity<List<MsgDTO>> getMsgPage(@PathVariable("project_id") int projectId, @PathVariable("page_id") int pageId){
//        return ResponseEntity.status(HttpStatus.OK).body(new ArrayList<>());
//    }

//    private Random random = new Random();

    @PostMapping("/project/{project_id}/msg")
    public ResponseEntity<ApiResponse<Object>> addMsg(@PathVariable("project_id") int projectId, @RequestBody() NewMsgDTO newMsgDTO){
        //TODO change random.nextLong..........
//        newMsgDTO.setMemberId(random.nextLong((2 - 1) +1) + 1);
        newMsgDTO.setMemberId(1);
        newMsgDTO.setProjectId(projectId);
        if(msgService.addNewMsg(newMsgDTO)){
            return ResponseEntity.status(HttpStatus.OK).body(ApiResponse
                    .builder()
                    .body(null)
                    .httpCode(HttpStatus.OK.value())
                    .build());
        }else{
            ApiResponse<Object> apiResponse = ApiResponse.builder()
                    .body(null)
                    .hasErrors(true)
                    .httpCode(HttpStatus.NO_CONTENT.value())
                    .build();
            apiResponse.addError("NO_CONTENT");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(apiResponse);
        }
    }
}

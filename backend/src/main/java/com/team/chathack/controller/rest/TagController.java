package com.team.chathack.controller.rest;

import com.team.chathack.dto.response.ApiResponse;
import com.team.chathack.dto.tags.NewTagDTO;
import com.team.chathack.dto.tags.TagDTO;
import com.team.chathack.service.ChatListenerWsService;
import com.team.chathack.service.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tag")
public record TagController(ChatListenerWsService chatListenerWsService, TagService tagService) {

    @PostMapping("/project/{project_id}/msg/{msg_id}")
    public ResponseEntity<ApiResponse<Boolean>> addTag(@PathVariable("project_id") long projectId, @PathVariable("msg_id") long msgId, @RequestBody NewTagDTO tagDTO){
        tagService.addTag(projectId,tagDTO);
//        chatListenerWsService.addTag(1);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.<Boolean>builder()
                .body(true)
                .type(ApiResponse.ApiResponseType.TAG_ADDED)
                .hasErrors(false)
                .build());
    }
    @GetMapping("/project/{project_id}")
    public ResponseEntity<ApiResponse<List<TagDTO>>> getAllTags(@PathVariable("project_id") long projectId){
        List<TagDTO> tagDTOS = tagService.getAll(projectId);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.<List<TagDTO>>builder()
                .body(tagDTOS)
                .type(ApiResponse.ApiResponseType.TAG_GET_ALL)
                .hasErrors(false)
                .build());
    }

//    @PutMapping("/project/{project_id}/msg/{msg_id}/tag/{tag_id}")
//    public ResponseEntity<Boolean> editTag(@PathVariable("project_id") int projectId,@PathVariable("msg_id") int msgId,@PathVariable("tag_id") int tagId){
////        chatListenerWsService.editTag(1);
//        return ResponseEntity.status(HttpStatus.OK).body(true);
//    }

    @DeleteMapping("/project/{project_id}/msg/{msg_id}/tag/{tag_id}")
    public ResponseEntity<Boolean> deleteTag(@PathVariable("project_id") int projectId,@PathVariable("msg_id") int msgId,@PathVariable("tag_id") int tagId){
//        chatListenerWsService.deleteTag(1);
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }
}

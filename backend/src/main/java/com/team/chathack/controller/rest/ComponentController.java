package com.team.chathack.controller.rest;


import com.team.chathack.dto.openai.ChatGptResultDTO;
import com.team.chathack.dto.response.ApiResponse;
import com.team.chathack.feign.model.OpenAiResponse;
import com.team.chathack.service.OpenAiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/component")
@RequiredArgsConstructor
public class ComponentController {
    private final OpenAiService openAiService;

    @GetMapping("/project/{project_id}/call/type/DES")
    public ResponseEntity<ApiResponse<ChatGptResultDTO>> getDes(@PathVariable("project_id") int projectId){
        ChatGptResultDTO chatGptResultDTO = new ChatGptResultDTO();
        OpenAiResponse openAiResponse = openAiService.callDes(projectId);

        chatGptResultDTO.setType("DES");
        chatGptResultDTO.setAnswer("");
        openAiResponse.getChoices().forEach(choice -> {
            chatGptResultDTO.setAnswer(chatGptResultDTO.getAnswer()+"\n"+choice.getMessage().getContent());
        });
        chatGptResultDTO.setAnswer(chatGptResultDTO.getAnswer().replaceAll("\n","\n\r"));
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse
                .<ChatGptResultDTO>builder()
                        .type(ApiResponse.ApiResponseType.OPENAI_RESPONSE_DES)
                        .httpCode(HttpStatus.OK.value())
                        .hasErrors(false)
                        .body(chatGptResultDTO)
                .build());
    }

    @GetMapping("/project/{project_id}/call/type/SQL")
    public ResponseEntity<ApiResponse<ChatGptResultDTO>> getSql(@PathVariable("project_id") int projectId){
        ChatGptResultDTO chatGptResultDTO = new ChatGptResultDTO();
        OpenAiResponse openAiResponse = openAiService.callSQL(projectId);

        chatGptResultDTO.setType("SQL");
        chatGptResultDTO.setAnswer("");
        openAiResponse.getChoices().forEach(choice -> {
            chatGptResultDTO.setAnswer(chatGptResultDTO.getAnswer()+"\n"+choice.getMessage().getContent());
        });
        chatGptResultDTO.setAnswer(chatGptResultDTO.getAnswer().replaceAll("\n","\n\r"));
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse
                .<ChatGptResultDTO>builder()
                .type(ApiResponse.ApiResponseType.OPENAI_RESPONSE_SQL)
                .httpCode(HttpStatus.OK.value())
                .hasErrors(false)
                .body(chatGptResultDTO)
                .build());
    }

    @GetMapping("/project/{project_id}/call/type/JAVA")
    public ResponseEntity<ApiResponse<ChatGptResultDTO>> getJava(@PathVariable("project_id") int projectId){
        ChatGptResultDTO chatGptResultDTO = new ChatGptResultDTO();
        OpenAiResponse openAiResponse = openAiService.callJava(projectId);

        chatGptResultDTO.setType("JAVA");
        chatGptResultDTO.setAnswer("");
        openAiResponse.getChoices().forEach(choice -> {
            chatGptResultDTO.setAnswer(chatGptResultDTO.getAnswer()+"\n"+choice.getMessage().getContent());
        });
        chatGptResultDTO.setAnswer(chatGptResultDTO.getAnswer().replaceAll("\n","\n\r"));
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse
                .<ChatGptResultDTO>builder()
                .type(ApiResponse.ApiResponseType.OPENAI_RESPONSE_JAVA)
                .httpCode(HttpStatus.OK.value())
                .hasErrors(false)
                .body(chatGptResultDTO)
                .build());
    }

//    @GetMapping("/project/{project_id}/call/type/CPP")
//    public ResponseEntity<ApiResponse<ChatGptResultDTO>> getCpp(@PathVariable("project_id") int projectId){
//        ChatGptResultDTO chatGptResultDTO = new ChatGptResultDTO();
//        OpenAiResponse openAiResponse = openAiService.callCpp(projectId);
//
//        chatGptResultDTO.setType("CPP");
//        chatGptResultDTO.setAnswer("");
//        openAiResponse.getChoices().forEach(choice -> {
//            chatGptResultDTO.setAnswer(chatGptResultDTO.getAnswer()+"\n"+choice.getMessage().getContent());
//        });
//        chatGptResultDTO.setAnswer(chatGptResultDTO.getAnswer().replaceAll("\n","\n\r"));
//        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse
//                .<ChatGptResultDTO>builder()
//                .type(ApiResponse.ApiResponseType.OPENAI_RESPONSE_CPP)
//                .httpCode(HttpStatus.OK.value())
//                .hasErrors(false)
//                .body(chatGptResultDTO)
//                .build());
//    }

    @GetMapping("/project/{project_id}/call/type/JSON")
    public ResponseEntity<ApiResponse<ChatGptResultDTO>> getJson(@PathVariable("project_id") int projectId){
        ChatGptResultDTO chatGptResultDTO = new ChatGptResultDTO();
        OpenAiResponse openAiResponse = openAiService.callJson(projectId);

        chatGptResultDTO.setType("JSON");
        chatGptResultDTO.setAnswer("");
        openAiResponse.getChoices().forEach(choice -> {
            chatGptResultDTO.setAnswer(chatGptResultDTO.getAnswer()+"\n"+choice.getMessage().getContent());
        });
        chatGptResultDTO.setAnswer(chatGptResultDTO.getAnswer().replaceAll("\n","\n\r"));
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse
                .<ChatGptResultDTO>builder()
                .type(ApiResponse.ApiResponseType.OPENAI_RESPONSE_JSON)
                .httpCode(HttpStatus.OK.value())
                .hasErrors(false)
                .body(chatGptResultDTO)
                .build());
    }
}

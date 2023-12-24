package com.team.chathack.feign;


import com.team.chathack.feign.model.OpenAiRequest;
import com.team.chathack.feign.model.OpenAiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "open-ai-methods",url = "https://api.openai.com",contextId = "openAiMethods")
public interface OpenAiMethods {

    @PostMapping("/v1/chat/completions")
    OpenAiResponse call(@RequestHeader(HttpHeaders.AUTHORIZATION) String key, @RequestBody OpenAiRequest request);
}

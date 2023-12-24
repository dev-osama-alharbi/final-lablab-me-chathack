package com.team.chathack.feign.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OpenAiResponse {
    private String id;
    private String object;
    private long created;
    private String model;
    private String system_fingerprint;
    private ArrayList<Choice> choices;
    private Usage usage;
}

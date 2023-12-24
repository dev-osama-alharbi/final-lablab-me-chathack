package com.team.chathack.dto.tags;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO{
    private Long id;
    private Long componentId;
    private Long msgId;
    private Long projectId;
    private String msg;
}
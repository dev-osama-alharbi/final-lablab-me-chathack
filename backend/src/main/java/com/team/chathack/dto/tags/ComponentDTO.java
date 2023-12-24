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
public class ComponentDTO {
    private Long id;
    private Long msgId;
    private Long projectId;
    private String msg;
    private String title;
    private String componentType;
}

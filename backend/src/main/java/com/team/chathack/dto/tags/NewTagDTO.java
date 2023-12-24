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
public class NewTagDTO {
    private Long msgId;
    private boolean statusNew;
    private boolean typeDb;
    private String title;
    private Long parentComponentId;
}

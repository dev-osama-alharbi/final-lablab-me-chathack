package com.team.chathack.dto.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class MsgDTO {
    private Long id;
    private String msg;
    private LocalDateTime dateTime;
    private long projectId;
    private long memberId;
}

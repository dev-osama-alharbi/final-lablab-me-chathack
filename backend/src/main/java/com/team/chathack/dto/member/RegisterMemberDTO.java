package com.team.chathack.dto.member;

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
public class RegisterMemberDTO {
    private int id;
    private int name;
    private int email;
    private int password;
    private int isActive;
    private int isDelete;
    private int username;

}

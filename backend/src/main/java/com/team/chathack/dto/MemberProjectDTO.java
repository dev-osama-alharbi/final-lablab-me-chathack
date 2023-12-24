package com.team.chathack.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.team.chathack.dto.member.RegisterMemberDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class MemberProjectDTO {
    private int isAcceptJoin;
    private int isDelete;
    private RegisterMemberDTO member;
    private ProjectDTO project;
    private MemberProjectTypeDTO memberProjectType;

}

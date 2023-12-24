package com.team.chathack.feign.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleAssistant extends Role{
    private String role = "assistant";
    private String content;
    public RoleAssistant(String content){
        this.content = content;
    }
}

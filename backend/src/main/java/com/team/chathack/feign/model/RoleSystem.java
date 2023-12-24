package com.team.chathack.feign.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleSystem extends Role{
    private String role = "system";
    private String content;
    public RoleSystem(String content){
        this.content = content;
    }
}

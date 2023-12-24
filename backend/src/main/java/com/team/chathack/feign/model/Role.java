package com.team.chathack.feign.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private String role;
    private String content;
    public static RoleUser init(String content){
        RoleUser roleSystem = new RoleUser();
        roleSystem.setContent(content);
        return roleSystem;
    }
}

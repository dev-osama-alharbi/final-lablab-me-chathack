package com.team.chathack.feign.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleUser extends Role{
    private String role = "user";
    private String content;
    public RoleUser(String content){
        this.content = content;
    }
}

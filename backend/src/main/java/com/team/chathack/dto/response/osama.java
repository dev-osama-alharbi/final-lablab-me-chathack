package com.team.chathack.dto.response;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class osama {
    private int id;
    private String Osama;
    private String password;

    public String getOsama() {
        return Osama;
    }

    public void setOsama(String osama) {
        this.Osama = osama;
    }
}

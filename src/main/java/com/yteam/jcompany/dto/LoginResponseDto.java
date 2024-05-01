package com.yteam.jcompany.dto;

import lombok.Data;

@Data
public class LoginResponseDto {
    private String loginKey;

    public LoginResponseDto(String loginKey){
        this.loginKey=loginKey;
    }
}

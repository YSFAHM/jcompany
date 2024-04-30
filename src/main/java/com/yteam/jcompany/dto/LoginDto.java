package com.yteam.jcompany.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDto {

    @NotBlank(message = "user name is required")
    private String userName;
    @NotBlank(message = "password is required")
    private String password;

}

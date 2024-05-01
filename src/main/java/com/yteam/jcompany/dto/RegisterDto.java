package com.yteam.jcompany.dto;
import com.yteam.jcompany.model.Auth;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterDto {

    //Long id;

    @NotBlank(message = "user name is required")
    private String userName;

    @NotBlank(message = "password is required")
    private String password;

    @NotNull(message = "company information is required")
    @Valid
    private CompanyDto company;


    public static Auth toModel(RegisterDto registerDto){
        Auth auth = new Auth();
        auth.setUserName(registerDto.getUserName());
        auth.setPassword(registerDto.getPassword());
        auth.setCompany(CompanyDto.toModel(registerDto.getCompany()));
        return auth;

    }


    public static RegisterDto toDto(Auth auth){
        RegisterDto registerDto = new RegisterDto();
        registerDto.setUserName(auth.getUserName());
        registerDto.setPassword(auth.getPassword());
        registerDto.setCompany(CompanyDto.toDto(auth.getCompany()));
        return registerDto;
    }
}


package com.yteam.jcompany.dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterDto {

    Long id;
    @NotBlank(message = "user name is required")
    private String userName;

    @NotBlank(message = "password is required")
    private String password;

    @NotNull(message = "company information is required")
    @Valid
    private CompanyDto companyDto;
}

package com.yteam.jcompany.dto;



import com.yteam.jcompany.model.Company;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CompanyDto {

    private Long id;

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "Email address is required")
    @Email(message = "Invalid email address")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "\\d{11}", message = "Phone number must be 11 digits")
    private String phoneNumber;

    @NotBlank(message = "name is required")
    private String service;

    @NotBlank(message = "name is required")
    private String description;

    @NotBlank(message = "address is required")
    private String address;

    @NotNull(message = "number of employee is required")
    private Integer numberOfEmployee;

        
        public static CompanyDto toDto(Company company) {
        CompanyDto companyDto = new CompanyDto();
        companyDto.setId(company.getId());
        companyDto.setName(company.getName());
        companyDto.setEmail(company.getEmail());
        companyDto.setPhoneNumber(company.getPhoneNumber());
        companyDto.setService(company.getService());
        companyDto.setDescription(company.getDescription());
        companyDto.setAddress(company.getAddress());
        companyDto.setNumberOfEmployee(company.getNumberOfEmployee());
        return companyDto;
    }

    public static Company toModel(CompanyDto companyDto) {
        Company company = new Company();
        company.setId(companyDto.getId());
        company.setName(companyDto.getName());
        company.setEmail(companyDto.getEmail());
        company.setPhoneNumber(companyDto.getPhoneNumber());
        company.setService(companyDto.getService());
        company.setDescription(companyDto.getDescription());
        company.setAddress(companyDto.getAddress());
        company.setNumberOfEmployee(companyDto.getNumberOfEmployee());
        return company;
    }
}


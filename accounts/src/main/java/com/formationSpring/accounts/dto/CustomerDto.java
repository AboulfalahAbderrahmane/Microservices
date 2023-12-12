package com.formationSpring.accounts.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CustomerDto {
    private Long id;
    private String name;
    private String email;
    private String mobileNumber;
    private AccountDto accountDto;
}

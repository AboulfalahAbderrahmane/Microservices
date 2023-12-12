package com.formationSpring.accounts.dto;

import lombok.Data;

@Data
public class AccountDto {
    private Long id;
    private String accountNumber;
    private String accountType;
    private String branchAddress;


}

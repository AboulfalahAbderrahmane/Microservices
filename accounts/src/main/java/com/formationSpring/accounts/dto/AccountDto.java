package com.formationSpring.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountDto {
    private Long id;
    @NotEmpty(message = "AccountNumber can not be empty")
    @Pattern(regexp = "(^0[5-7]{1}[0-9]{8}$)",message = "AccountNumber must be 10 digits")
    private String accountNumber;
    @NotEmpty(message = "accountType can not be empty")
    private String accountType;
    @NotEmpty(message = "branchAddress can not be empty")
    private String branchAddress;


}

package com.formationSpring.accounts.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto {
    private Long id;
    @NotEmpty(message = "Name can not be empty")
    @Size(min=5,max=30,message="The length of the Customer name should be between 5 and 30")
    private String name;
    @NotEmpty(message = "Email can not be empty")
    @Email(message = "yuo should respect the format of email like :example@gmail.com")
    private String email;
    @Pattern(regexp = "(^0[5-7]{1}[0-9]{8}$)",message = "mobile number must be 10 digits")

    private String mobileNumber;
    private AccountDto accountDto;
}

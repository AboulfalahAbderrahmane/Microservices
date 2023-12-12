package com.formationSpring.accounts.controllers;

import com.formationSpring.accounts.constants.AccountsConstantes;
import com.formationSpring.accounts.dto.CustomerDto;
import com.formationSpring.accounts.dto.ResponseDto;
import com.formationSpring.accounts.services.IAccountService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping(path="/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated @AllArgsConstructor
public class AccountsController {

    private IAccountService iAccountService;
    @PostMapping(path = "/create")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto){
        iAccountService.createAccount(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(AccountsConstantes.STATUS_201,AccountsConstantes.MESSAGE_201));
    }
    @GetMapping(path = "/fetch")
    public ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam
                                                               @Pattern(regexp = "d{10}",message = "mobile number must be 10 digits")
                                                               String mobileNumber){
        return ResponseEntity.status(HttpStatus.FOUND).body(iAccountService.fetchAccount(mobileNumber));
    }
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccount(@Valid @RequestBody CustomerDto customerDto){
        boolean isApdated= iAccountService.updateAccount(customerDto);
        if(isApdated){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountsConstantes.STATUS_200,
                    AccountsConstantes.MESSAGE_200));
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(AccountsConstantes.STATUS_500,AccountsConstantes.MESSAGE_500));
        }
    }
    @DeleteMapping("/delete/{phoneNumber}")
    public ResponseEntity<ResponseDto> deleteAccount(@PathVariable
                                                         @Pattern(regexp = "d{10}",message = "mobile number must be 10 digits")
                                                         String phoneNumber){
        boolean isDeleted=iAccountService.deleteAccount(phoneNumber);
        if(isDeleted){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(HttpStatus.OK.toString(),AccountsConstantes.STATUS_200));

        }else{
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(HttpStatus.EXPECTATION_FAILED.toString(),
                    AccountsConstantes.MESSAGE_417_DELETE));
        }
    }

}

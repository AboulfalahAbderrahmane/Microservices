package com.formationSpring.accounts.services;

import com.formationSpring.accounts.dto.CustomerDto;
import com.formationSpring.accounts.repositories.AccountRepository;

public interface IAccountService {
    void createAccount(CustomerDto customerDto);
    CustomerDto fetchAccount(String mobileNumber);
    boolean updateAccount(CustomerDto customerDto);
    boolean deleteAccount(String accountNumbern);
}

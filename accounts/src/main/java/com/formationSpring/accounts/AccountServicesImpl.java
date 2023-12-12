package com.formationSpring.accounts;

import com.formationSpring.accounts.constants.AccountsConstantes;
import com.formationSpring.accounts.dto.AccountDto;
import com.formationSpring.accounts.dto.CustomerDto;
import com.formationSpring.accounts.entities.Account;
import com.formationSpring.accounts.entities.Customer;
import com.formationSpring.accounts.exception.CustomerAlreadyExistsException;
import com.formationSpring.accounts.exception.RessourceNotFoundException;
import com.formationSpring.accounts.mapper.AccountsMapper;
import com.formationSpring.accounts.mapper.CustomerMapper;
import com.formationSpring.accounts.repositories.AccountRepository;
import com.formationSpring.accounts.repositories.CustomerRepository;
import com.formationSpring.accounts.services.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServicesImpl implements IAccountService {
   private AccountRepository accountRepository;
   private CustomerRepository customerRepository;
    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer= CustomerMapper.mapToCustomer(customerDto,new Customer());
        Optional<Customer> optionalCustomer=customerRepository.findByMobileNumber(customer.getMobileNumber());
        if(optionalCustomer.isPresent()){
            throw new CustomerAlreadyExistsException("Customer Already exist with the phone Number"
                    +customerDto.getMobileNumber());
        }
        Customer savedCustomer=customerRepository.save(customer);
        accountRepository.save(createNewAccount(savedCustomer));
    }



    private Account createNewAccount(Customer customer) {
        Account newAccount = new Account();
        newAccount.setId(customer.getId());
        //long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(customer.getMobileNumber());
        newAccount.setAccountType(AccountsConstantes.SAVINGS);
        newAccount.setBranchAddress(AccountsConstantes.ADDRESS);
        return newAccount;
    }
    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        Customer customer=customerRepository.findByMobileNumber(mobileNumber).
                orElseThrow(()->new RessourceNotFoundException("Customer","mobileNumber",mobileNumber));
        Account account=accountRepository.findByAccountNumber(customer.getMobileNumber())
                .orElseThrow(()->new RessourceNotFoundException("account","customerId",customer.getId().toString()));

        CustomerDto customerDto=CustomerMapper.mapToCustomerDto(customer,new CustomerDto());
        customerDto.setAccountDto(AccountsMapper.mapToAccountsDto(account,new AccountDto()));
        return customerDto;
    }

    @Override
    public boolean updateAccount(CustomerDto customerDto) {
        AccountDto accountDto = customerDto.getAccountDto();
        boolean isUpdated=false;
        if(accountDto!=null){
            Account accounts=accountRepository.findById(accountDto.getId()).orElseThrow(()->new RessourceNotFoundException("Account","AccountNumber",
                    accountDto.getAccountNumber()));
            AccountsMapper.mapToAccounts(accountDto,accounts);
            accounts=accountRepository.save(accounts);
            Long customerId=accounts.getId();
            Customer customer= customerRepository.findById(customerId).orElseThrow(()->new RessourceNotFoundException("Customer","CustomerId",
                    customerId.toString()));
            CustomerMapper.mapToCustomer(customerDto,customer);
            customerRepository.save(customer);
            isUpdated=true;
        }

        return isUpdated;
    }

    @Override
    public boolean deleteAccount(String accountNumber) {
        Customer customer=customerRepository.findByMobileNumber(accountNumber).orElseThrow(()->new RessourceNotFoundException("Customer","customerNumber",
                accountNumber));
        Account account=accountRepository.findByAccountNumber(accountNumber).orElseThrow(()->new RessourceNotFoundException("Account","AccountNumber",
                accountNumber));
        accountRepository.deleteById(account.getId());
        customerRepository.deleteById(customer.getId());


        return true;
    }

}

package com.formationSpring.accounts.repositories;

import com.formationSpring.accounts.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
     Optional<Account> findById(Long id);
     Optional<Account> findByAccountNumber(String accounNumber);
     void deleteByAccountNumber(String accountNumber);

}

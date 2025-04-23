package com.example.patterns_banking.services;

import com.example.patterns_banking.dtos.AccountDto;
import com.example.patterns_banking.models.Account;
import com.example.patterns_banking.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    private final AccountRepository repository;

    public AccountService() {
        this.repository = AccountRepository.getInstance();
    }

    @Transactional
    public Account create(AccountDto dto) {
        Account account = Account
                .builder()
                .number(dto.getNumber())
                .balance(dto.getBalance())
                .accountType(dto.getAccountType())
                .isActive(dto.getIsActive())
                .build();

        return this.repository.save(account);
    }
}

package com.example.patterns_banking.controllers;

import com.example.patterns_banking.dtos.AccountDto;
import com.example.patterns_banking.models.Account;
import com.example.patterns_banking.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService service;

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody AccountDto requestBody) {
        return ResponseEntity.ok(this.service.create(requestBody));
    }
}

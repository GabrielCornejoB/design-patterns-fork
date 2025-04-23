package com.example.patterns_banking.dtos;

import com.example.patterns_banking.models.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private String number;
    private Account.AccountType accountType;
    private BigDecimal balance;
    private Boolean isActive;
}

package com.example.patterns_banking.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String number;

    @Enumerated(EnumType.STRING)
    private AccountType type;

    private BigDecimal balance;

    private Boolean isActive = true;

    public enum AccountType{AHORROS, CORRIENTE};

    private Account(Builder builder) {
        this.id = builder.id;
        this.number = builder.number;
        this.balance = builder.balance;
        this.type = builder.accountType;
        this.isActive = builder.isActive;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static class Builder {
        private Long id;
        private String number;
        private AccountType accountType;
        private BigDecimal balance;
        private Boolean isActive;

        private Builder() {}

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder number(String number) {
            this.number = number;
            return this;
        }

        public Builder balance(BigDecimal balance) {
            this.balance = balance;
            return this;
        }

        public Builder accountType(AccountType accountType) {
            this.accountType = accountType;
            return this;
        }

        public Builder isActive(Boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public Account build() {
            return new Account(this);
        }
    }
}

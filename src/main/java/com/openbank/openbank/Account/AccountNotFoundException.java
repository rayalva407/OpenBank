package com.openbank.openbank.Account;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(Long id) {
        super("Could not find Account with id: " + id);
    }
}

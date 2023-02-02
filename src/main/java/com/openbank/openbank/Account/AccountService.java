package com.openbank.openbank.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class AccountService {


    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account getAccount(@PathVariable Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException(id));
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account editAccount(Account account) {

        return accountRepository.save(account);
    }

    public Account deleteAccount(Long id) {
        Account deletedAccount = accountRepository.findById(id).get();
        accountRepository.deleteById(id);
        return deletedAccount;
    }
}

package com.openbank.openbank.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {


    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/accounts/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccount(id);
    }

    @PostMapping("/accounts")
    public Account newAccount(@RequestBody Account account) {
        return accountService.saveAccount(account);
    }

    @PutMapping("/accounts/{id}")
    public Account editAccount(@RequestBody Account account, @PathVariable Long id) {
        return accountService.editAccount(account);
    }

    @DeleteMapping("/accounts/{id}")
    public Account deleteAccount(@PathVariable Long id) {
        return accountService.deleteAccount(id);
    }
}

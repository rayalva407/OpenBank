package com.openbank.openbank;


import com.openbank.openbank.Account.Account;
import com.openbank.openbank.Account.AccountRepository;
import com.openbank.openbank.User.User;
import com.openbank.openbank.User.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(AccountRepository accountRepository, UserRepository userRepository) {
        return args -> {
            User ray = new User("Ray", "Alva");
            User elena = new User("Elena", "Nolasco");
            Account rayAccount = new Account(987654321, 0, "Savings");
            Account elenaAccount = new Account(123456789, 100, "Checking");
            ray.getAccounts().add(rayAccount);
            elena.getAccounts().add(elenaAccount);
            rayAccount.setUser(ray);
            elenaAccount.setUser(elena);
            log.info("Preloading " + userRepository.save(ray));
            log.info("Preloading " + userRepository.save(elena));
            log.info("Preloading " + accountRepository.save(elenaAccount));
            log.info("Preloading " + accountRepository.save(rayAccount));
        };
    }
}

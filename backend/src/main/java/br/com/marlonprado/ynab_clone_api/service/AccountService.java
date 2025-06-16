package br.com.marlonprado.ynab_clone_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marlonprado.ynab_clone_api.entity.Account;
import br.com.marlonprado.ynab_clone_api.repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account save(Account account) {
        account.setCreatedAt(java.time.LocalDateTime.now());
        account.setUpdatedAt(java.time.LocalDateTime.now());
        return accountRepository.save(account);
    }

    public String getAccountInfos(String name) {
        return "Account info: " + name;
    }
}

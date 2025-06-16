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

    public List<Account> list() {
        return accountRepository.findAll();
    }

    public Account update(Account account){
        return accountRepository.save(account);
    }

    public Account delete(Long id){
        return accountRepository.deleteById(id);
    }


}

package br.com.marlonprado.ynab_clone_api.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marlonprado.ynab_clone_api.dto.AccountDTO;
import br.com.marlonprado.ynab_clone_api.entity.Account;
import br.com.marlonprado.ynab_clone_api.repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account save(AccountDTO accountDTO) {
        Account account = new Account();
        account.setCreatedAt(LocalDateTime.now());
        account.setUpdatedAt(LocalDateTime.now());
        return accountRepository.save(account);
    }

    public List<AccountDTO> list() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream()
                .map(AccountDTO::new)
                .toList();
    }

    public Optional<AccountDTO> findById(Long id) {
        Optional<Account> account = accountRepository.findById(id); 
        return account.map(AccountDTO::new);
    }

    public Optional<AccountDTO> update(Long id, AccountDTO accountDTO) {
        return accountRepository.findById(id)
                .map(existingAccount -> {
                    existingAccount.setUpdatedAt(LocalDateTime.now());
                    Account updated = accountRepository.save(existingAccount);
                    return new AccountDTO(updated);
                });
    }

    public boolean delete(Long id) {
        if (accountRepository.existsById(id)) {
            accountRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

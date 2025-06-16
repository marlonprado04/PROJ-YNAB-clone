package br.com.marlonprado.ynab_clone_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.marlonprado.ynab_clone_api.entity.Account;
import br.com.marlonprado.ynab_clone_api.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> list() {
        return accountService.list();
    }

    @PostMapping
    public Account create(@RequestBody Account account) {
        return accountService.save(account);
    }

    @PutMapping
    public Account update(@RequestBody Account account){
        return accountService.update(account);
    }

    @DeleteMapping("/{id}")
    public Account delete(@PathVariable("id") Long id){
        return accountService.delete(id);
    }
}
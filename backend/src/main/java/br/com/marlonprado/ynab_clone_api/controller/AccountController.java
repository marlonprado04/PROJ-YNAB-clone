package br.com.marlonprado.ynab_clone_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marlonprado.ynab_clone_api.entity.Account;
import br.com.marlonprado.ynab_clone_api.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public String getAccountInfos() {
        return accountService.getAccountInfos("NUBANK");
    }

    @PostMapping("/create/")
    public Account createAccount(@RequestBody Account account) {
        return accountService.save(account);
    }

}

package br.com.marlonprado.ynab_clone_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marlonprado.ynab_clone_api.dto.AccountDTO;
import br.com.marlonprado.ynab_clone_api.entity.Account;
import br.com.marlonprado.ynab_clone_api.service.AccountService;


@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<AccountDTO> list() {
        return accountService.list();
    }
    

    @PostMapping
    public ResponseEntity<AccountDTO> create(@RequestBody AccountDTO accountDTO) {
        Account created = accountService.save(accountDTO);
        return new ResponseEntity<>(new AccountDTO(created), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountDTO> update(@PathVariable Long id, @RequestBody AccountDTO accountDTO){
        Optional<AccountDTO> updated = accountService.update(id, accountDTO);
        return updated
            .map(dto -> ResponseEntity.ok(dto))
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        boolean deleted = accountService.delete(id);
        if(deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}

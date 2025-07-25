package br.com.marlonprado.ynab_clone_api.dto;

import br.com.marlonprado.ynab_clone_api.entity.Account;

public class AccountDTO {
    private Long id;
    private String name;

    public AccountDTO() {
    }

    public AccountDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public AccountDTO(Account account) {
        id = account.getId();
        name = account.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}

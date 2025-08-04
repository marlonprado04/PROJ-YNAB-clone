package br.com.marlonprado.ynab_clone_api.account;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AccountDTO {

    private Long id;
    private String name;
    private AccountTypeEnum type;
    private BigDecimal balance;
    private boolean isBudgetedIncluded;
    private LocalDateTime balanceDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public AccountDTO() {
    }

    public AccountDTO(Long id, String name) {
        this.id = id;
        this.name = name;
        this.type = AccountTypeEnum.CASH;
        this.balance = BigDecimal.ZERO;
        this.isBudgetedIncluded = false;
        this.balanceDate = LocalDateTime.now();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public static AccountDTO fromEntity(AccountEntity account) {
        AccountDTO dto = new AccountDTO();
        dto.setId(account.getId());
        dto.setName(account.getName());
        dto.setType(account.getType());
        dto.setBalance(account.getBalance());
        dto.setBudgetedIncluded(account.isBudgetedIncluded());
        dto.setBalanceDate(account.getBalanceDate());
        dto.setCreatedAt(account.getCreatedAt());
        dto.setUpdatedAt(account.getUpdatedAt());
        return dto;
    }

    // Getters e Setters
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

    public AccountTypeEnum getType() {
        return type;
    }

    public void setType(AccountTypeEnum type) {
        this.type = type;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public boolean isBudgetedIncluded() {
        return isBudgetedIncluded;
    }

    public void setBudgetedIncluded(boolean isBudgetedIncluded) {
        this.isBudgetedIncluded = isBudgetedIncluded;
    }

    public LocalDateTime getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(LocalDateTime balanceDate) {
        this.balanceDate = balanceDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}

package br.com.marlonprado.ynab_clone_api.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.marlonprado.ynab_clone_api.model.enums.AccountType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private AccountType type;

    private BigDecimal balance;

    private boolean isBudgetedIncluded;

    private LocalDateTime balanceDate;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    // TODO Add relationship with Transaction
}

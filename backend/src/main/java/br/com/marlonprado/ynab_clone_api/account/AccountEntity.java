package br.com.marlonprado.ynab_clone_api.account;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "account")
public class AccountEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private AccountTypeEnum type;

    private BigDecimal balance;

    private boolean isBudgetedIncluded;

    private LocalDateTime balanceDate;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}

package br.com.marlonprado.ynab_clone_api.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.marlonprado.ynab_clone_api.model.enums.account.AccountType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "account")
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

    @OneToMany(mappedBy = "fromAccount")
    private List<Transaction> sentTransactions= new ArrayList<>();

    @OneToMany(mappedBy = "toAccount")
    private List<Transaction> receivedTransactions= new ArrayList<>();
}

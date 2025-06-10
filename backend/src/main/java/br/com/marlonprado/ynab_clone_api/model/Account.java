package br.com.marlonprado.ynab_clone_api.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private String type;

    private BigDecimal balance;

    private boolean isBudgetedIncluded;

    private LocalDate balanceDate;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}

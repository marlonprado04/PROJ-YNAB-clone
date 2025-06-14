package br.com.marlonprado.ynab_clone_api.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

import br.com.marlonprado.ynab_clone_api.entity.enums.transaction.RecurrenceFrequency;
import br.com.marlonprado.ynab_clone_api.entity.enums.transaction.RecurrenceType;
import br.com.marlonprado.ynab_clone_api.entity.enums.transaction.Status;
import br.com.marlonprado.ynab_clone_api.entity.enums.transaction.TransactionType;
import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue
    private Long id;

    private String payee;
    private String description;
    private BigDecimal amount;
    private LocalDateTime date;
    @Nullable
    private Integer installmentCount;
    private boolean manualOverride;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    private RecurrenceType recurrenceType;

    @Enumerated(EnumType.STRING)
    private RecurrenceFrequency recurrenceFrequency;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "from_account_id")
    @NotNull
    private Account fromAccount;

    @ManyToOne
    @JoinColumn(name = "to_account_id")
    @Nullable
    private Account toAccount;

    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    @Nullable
    private Subcategory subcategory;

    // TODO Add UUID for transferGroupId (nullable if not transfer)
    // TODO Add UUID for groupId (nullable if not fixed / installment)

}

package br.com.marlonprado.ynab_clone_api.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.marlonprado.ynab_clone_api.model.enums.transaction.RecurrenceFrequency;
import br.com.marlonprado.ynab_clone_api.model.enums.transaction.RecurrenceType;
import br.com.marlonprado.ynab_clone_api.model.enums.transaction.Status;
import br.com.marlonprado.ynab_clone_api.model.enums.transaction.TransactionType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Transaction {

    @Id
    @GeneratedValue
    private Long id;

    private String payee;
    private String description;
    private BigDecimal amount;
    private LocalDateTime date;
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


    // TODO Add UUID for transferGroupId (nullable if not transfer)
    // TODO Add UUID for groupId (nullable if not fixed / installment)


    // TODO Add relationship with Account (origin)
    // TODO Add relationship with Account (destination, nullable if doesnt transfer)
    // TODO Add relationship with Subcategory
}

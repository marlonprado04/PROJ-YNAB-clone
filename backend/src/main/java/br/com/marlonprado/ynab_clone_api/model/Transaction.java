package br.com.marlonprado.ynab_clone_api.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
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
    

    // TODO Add Enum for recurrenceType (e.g. FIXED, INSTALLMENT)
    // TODO Add Enum for recurrenceFrequency (DAILY, WEEKLY, BIWEEKLY, MONTHLY, BIMONTHLY, TRIMONTHLY, SIXMONTHLY, YEARLY) (nullable)
    // TODO Add Enum for transactionType (e.g., INCOME, EXPENSE, TRANSFER)
    // TODO Add Enum for status (e.g., PENDING, POSTED, RECONCILED, VOIDED)


    // TODO Add UUID for transferGroupId (nullable if not transfer)
    // TODO Add UUID for groupId (nullable if not fixed / installment)


    // TODO Add relationship with Account (origin)
    // TODO Add relationship with Account (destination, nullable if doesnt transfer)
    // TODO Add relationship with Subcategory
}

package br.com.marlonprado.ynab_clone_api.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import br.com.marlonprado.ynab_clone_api.account.AccountEntity;
import br.com.marlonprado.ynab_clone_api.subcategory.SubcategoryEntity;
import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "transaction")
public class TransactionEntity {

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
    private RecurrenceTypeEnum recurrenceType;

    @Enumerated(EnumType.STRING)
    private RecurrenceFrequencyEnum recurrenceFrequency;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @ManyToOne
    @JoinColumn(name = "from_account_id")
    @NotNull
    private AccountEntity fromAccount;

    @ManyToOne
    @JoinColumn(name = "to_account_id")
    @Nullable
    private AccountEntity toAccount;

    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    @Nullable
    private SubcategoryEntity subcategory;

    private UUID transferGroupId;
    private UUID groupId;
}

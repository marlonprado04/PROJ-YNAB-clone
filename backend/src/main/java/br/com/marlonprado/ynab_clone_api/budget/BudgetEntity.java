package br.com.marlonprado.ynab_clone_api.budget;

import java.time.LocalDateTime;

import br.com.marlonprado.ynab_clone_api.subcategory.SubcategoryEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "budget")
public class BudgetEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Integer month;
    private Integer year;
    private String plannedAmount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "subcategory_id")
    private SubcategoryEntity subcategory;
}

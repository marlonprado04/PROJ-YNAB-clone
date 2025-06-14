package br.com.marlonprado.ynab_clone_api.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Budget {
    @Id
    @GeneratedValue
    private Long id;
    private Integer month;
    private Integer year;
    private String plannedAmount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // TODO Add relationship with subcategory
}

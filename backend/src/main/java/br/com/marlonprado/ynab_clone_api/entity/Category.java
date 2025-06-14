package br.com.marlonprado.ynab_clone_api.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // TODO Add relationship with Subcategory
}

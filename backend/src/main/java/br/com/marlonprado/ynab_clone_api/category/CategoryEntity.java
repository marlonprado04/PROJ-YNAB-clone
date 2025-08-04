package br.com.marlonprado.ynab_clone_api.category;

import java.time.LocalDateTime;
import java.util.List;

import br.com.marlonprado.ynab_clone_api.subcategory.SubcategoryEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "category")
    private List<SubcategoryEntity> subcategories;

}

package br.com.marlonprado.ynab_clone_api.category;

import java.time.LocalDateTime;
import java.util.List;

import br.com.marlonprado.ynab_clone_api.subcategory.SubcategoryEntity;

public class CategoryDTO {

    private Long id;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private List<SubcategoryEntity> subcategories;

    public CategoryDTO() {
    }

    public CategoryDTO(Long id, String name) {
        this.id = id;
        this.name = name;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.subcategories = List.of();
    }   

    public static CategoryDTO fromEntity(CategoryEntity category) {
        CategoryDTO categoryDto = new CategoryDTO();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setCreatedAt(category.getCreatedAt());
        categoryDto.setUpdatedAt(category.getUpdatedAt());
        categoryDto.setSubcategories(category.getSubcategories());
        return categoryDto;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<SubcategoryEntity> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<SubcategoryEntity> subcategories) {
        this.subcategories = subcategories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package br.com.marlonprado.ynab_clone_api.subcategory;
import java.time.LocalDateTime;

import br.com.marlonprado.ynab_clone_api.category.CategoryDTO;

@Data
public class SubcategoryDTO {
    private Long id;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private CategoryDTO category;
    public SubcategoryDTO() {
    }

    public SubcategoryDTO(Long id, String name, CategoryDTO category) {
        this.id = id;
        this.name = name;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.category = category;
    }

    public static SubcategoryDTO fromEntity(SubcategoryEntity subcategory) {
        SubcategoryDTO subcategoryDto = new SubcategoryDTO();
        subcategoryDto.setId(subcategory.getId());
        subcategoryDto.setName(subcategory.getName());
        subcategoryDto.setCreatedAt(subcategory.getCreatedAt());
        subcategoryDto.setUpdatedAt(subcategory.getUpdatedAt());
        subcategoryDto.setCategory(CategoryDTO.fromEntity(subcategory.getCategory()));
        return subcategoryDto;

    }


}

package br.com.marlonprado.ynab_clone_api.category;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;
    @Autowired
    private final ModelMapper modelMapper;

    public CategoryService(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    public CategoryEntity save(CategoryDTO categoryDTO) {
        CategoryEntity category = new CategoryEntity();
        modelMapper.map(categoryDTO, category);

        LocalDateTime now = LocalDateTime.now();
        category.setCreatedAt(now);
        category.setUpdatedAt(now);

        return categoryRepository.save(category);
    }

    public Optional<CategoryDTO> findById(Long id) {
        return categoryRepository.findById(id)
                .map(CategoryDTO::fromEntity);
    }

    public List<CategoryDTO> list() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryDTO::fromEntity)
                .toList();
    }

    public Optional<CategoryDTO> update(Long id, CategoryDTO categoryDTO) {
        return categoryRepository.findById(id)
                .map(category -> {
                    modelMapper.map(categoryDTO, category);
                    category.setUpdatedAt(LocalDateTime.now());
                    CategoryEntity updated = categoryRepository.save(category);
                    return CategoryDTO.fromEntity(updated);
                });
    }

    public boolean delete(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return true;
        }

        return false;

    }

}

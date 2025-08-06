package br.com.marlonprado.ynab_clone_api.subcategory;


@Service
public class SubcategoryService {
    private final SubcategoryRepository subcategoryRepository;
    private final ModelMapper modelMapper;
    private final SubcategoryDTO subcategoryDTO;

    @Autowired
    public SubcategoryService(SubcategoryRepository subcategoryRepository, ModelMapper modelMapper, SubcategoryDTO subcategoryDTO) {
        this.subcategoryRepository = subcategoryRepository;
        this.modelMapper = modelMapper;
        this.subcategoryDTO = subcategoryDTO;
    }

        public SubcategoryEntity save(SubcategoryDTO subcategoryDTO) {
        SubcategoryEntity subcategory = new SubcategoryEntity();
        modelMapper.map(subcategoryDTO, subcategory);
        LocalDateTime now = LocalDateTime.now();
        category.setCreatedAt(now);
        category.setUpdatedAt(now);
        return subcategoryRepository.save(subcategory);
    }


}

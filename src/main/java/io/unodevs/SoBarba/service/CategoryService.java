package io.unodevs.SoBarba.service;

import io.unodevs.SoBarba.mapper.BarberShopMapper;
import io.unodevs.SoBarba.mapper.CategoryMapper;
import io.unodevs.SoBarba.model.Category;
import io.unodevs.SoBarba.model.dto.CategoryDTO;
import io.unodevs.SoBarba.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static io.unodevs.SoBarba.service.util.ValidateEntityService.validateOptional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private BarberShopService barberShopService;
    @Autowired
    private CategoryMapper categoryMapper;

    public List<CategoryDTO> findAll(){
        return categoryMapper.toCategoryDTOList(categoryRepository.findAll());
    }

    public CategoryDTO findById(Long id){
        return categoryMapper.toCategoryDTO(validateOptional(categoryRepository.findById(id)));
    }

    public CategoryDTO create(CategoryDTO dto){
        Category entity = categoryRepository.save(categoryMapper.toCategory(dto));
        return categoryMapper.toCategoryDTO(entity);
    }

    public CategoryDTO updateById(Long id, CategoryDTO category){
        CategoryDTO categoryDataDTO = findById(id);

        categoryDataDTO.setName(category.getName());
        categoryDataDTO.setActive(category.getActive());

        categoryRepository.save(categoryMapper.toCategory(categoryDataDTO));
        return categoryDataDTO;
    }

    public void deleteById(Long id){
        Category categoryDeleted = categoryMapper.toCategory(findById(id));
        categoryRepository.deleteById(categoryDeleted.getId());
    }

}

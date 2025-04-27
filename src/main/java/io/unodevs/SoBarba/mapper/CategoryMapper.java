package io.unodevs.SoBarba.mapper;

import io.unodevs.SoBarba.model.Category;
import io.unodevs.SoBarba.model.dto.CategoryDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toCategory(CategoryDTO dto);
    CategoryDTO toCategoryDTO(Category entity);
    List<Category> toCategoryList(List<CategoryDTO> dtos);
    List<CategoryDTO> toCategoryDTOList(List<Category> entities);
}

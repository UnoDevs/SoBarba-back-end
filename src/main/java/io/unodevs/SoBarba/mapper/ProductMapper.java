package io.unodevs.SoBarba.mapper;

import io.unodevs.SoBarba.model.Product;
import io.unodevs.SoBarba.model.dto.ProductDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(ProductDTO dto);
    ProductDTO toProductDTO(Product entity);
    List<Product> toProductList(List<ProductDTO> dtos);
    List<ProductDTO> toProductDTOList(List<Product> entities);
}

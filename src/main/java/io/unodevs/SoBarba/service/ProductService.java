package io.unodevs.SoBarba.service;

import io.unodevs.SoBarba.mapper.ProductMapper;
import io.unodevs.SoBarba.model.Category;
import io.unodevs.SoBarba.model.Product;
import io.unodevs.SoBarba.model.dto.ProductDTO;
import io.unodevs.SoBarba.repository.CategoryRepository;
import io.unodevs.SoBarba.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static io.unodevs.SoBarba.service.util.ValidateEntityService.validateOptional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductMapper productMapper;

    public List<ProductDTO> findAll() {
        return productMapper.toProductDTOList(productRepository.findAll());
    }

    public ProductDTO findById(Long id) {
        return productMapper.toProductDTO(validateOptional(productRepository.findById(id)));
    }

    public ProductDTO create(ProductDTO dto) {
        Product product = productMapper.toProduct(dto);

        Category category = validateOptional(categoryRepository.findById(dto.getCategoryId()));
        category.addProduct(product);

        productRepository.save(product);
        categoryRepository.save(category);

        ProductDTO response = productMapper.toProductDTO(product);
        response.setCategoryId(category.getId());
        return response;
    }

    public ProductDTO updateById(ProductDTO requestDto, Long id) {
        ProductDTO productDataDTO = findById(id);

        productDataDTO.setName(requestDto.getName());
        productDataDTO.setHasStock(requestDto.getHasStock());
        productDataDTO.setSalePrice(requestDto.getSalePrice());
        productDataDTO.setPurchasePrice(requestDto.getPurchasePrice());
        productDataDTO.setActive(requestDto.getActive());

        Product product = productMapper.toProduct(productDataDTO);

        if(requestDto.getCategoryId() != null){
            Category category = validateOptional(categoryRepository.findById(requestDto.getCategoryId()));
            category.addProduct(product);
            productDataDTO.setCategoryId(requestDto.getCategoryId());
            categoryRepository.save(category);
        } else {
            productDataDTO.setCategoryId(validateOptional(productRepository.findByIdWithCategory(id)).getCategory().getId());
        }

        productRepository.save(product);
        return productDataDTO;
    }

    public void delete(Long id) {
        ProductDTO product = findById(id);
        productRepository.deleteById(product.getId());
    }
}

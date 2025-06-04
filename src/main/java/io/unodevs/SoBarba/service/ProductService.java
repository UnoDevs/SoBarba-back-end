package io.unodevs.SoBarba.service;

import io.unodevs.SoBarba.mapper.ProductMapper;
import io.unodevs.SoBarba.model.Category;
import io.unodevs.SoBarba.model.Product;
import io.unodevs.SoBarba.dto.ProductDTO;
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
        return productMapper.toProductDTOList(productRepository.findAllWithCategory());
    }

    public ProductDTO findById(Long id) {
        return productMapper.toProductDTO(validateOptional(productRepository.findByIdWithCategory(id)));
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
        Product product = validateOptional(productRepository.findByIdWithCategory(id));

        product.setName(requestDto.getName());
        product.setHasStock(requestDto.getHasStock());
        product.setSalePrice(requestDto.getSalePrice());
        product.setPurchasePrice(requestDto.getPurchasePrice());
        product.setActive(requestDto.getActive());

        if(requestDto.getCategoryId() != null){
            Category category = validateOptional(categoryRepository.findById(requestDto.getCategoryId()));
            category.addProduct(product);
            categoryRepository.save(category);
        }
        productRepository.save(product);

        ProductDTO responseDTO = productMapper.toProductDTO(product);
        responseDTO.setCategoryId(product.getCategory().getId());
        return responseDTO;
    }

    public void delete(Long id) {
        ProductDTO product = findById(id);
        productRepository.deleteById(product.getId());
    }
}

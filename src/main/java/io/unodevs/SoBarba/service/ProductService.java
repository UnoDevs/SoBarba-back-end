package io.unodevs.SoBarba.service;

import io.unodevs.SoBarba.mapper.ProductMapper;
import io.unodevs.SoBarba.model.Product;
import io.unodevs.SoBarba.model.dto.ProductDTO;
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
    private ProductMapper productMapper;

    public List<ProductDTO> findAll() {
        return productMapper.toProductDTOList(productRepository.findAll());
    }

    public ProductDTO findById(Long id) {
        return productMapper.toProductDTO(validateOptional(productRepository.findById(id)));
    }

    public ProductDTO create(ProductDTO product) {
        Product response = productRepository.save(productMapper.toProduct(product));
        return productMapper.toProductDTO(response);
    }

    public ProductDTO updateById(ProductDTO product, Long id) {
        ProductDTO productDataDTO = findById(id);

        productDataDTO.setName(product.getName());
        productDataDTO.setHasStock(product.getHasStock());
        productDataDTO.setSalePrice(product.getSalePrice());
        productDataDTO.setPurchasePrice(product.getPurchasePrice());
        productDataDTO.setActive(product.getActive());

        productRepository.save(productMapper.toProduct(productDataDTO));
        return productDataDTO;
    }

    public void delete(Long id) {
        ProductDTO product = findById(id);
        productRepository.deleteById(product.getId());
    }
}

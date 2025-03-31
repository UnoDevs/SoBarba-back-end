package io.unodevs.SoBarba.service;

import io.unodevs.SoBarba.exception.ProductNotFoundException;
import io.unodevs.SoBarba.model.Product;
import io.unodevs.SoBarba.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return validateOptional(productRepository.findById(id));
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public Product update(Product product, Long id) {

        Product productUpdated = validateOptional(
                productRepository.findById(id).map(val -> {
                    val.setActive(product.isActive());
                    val.setHasStock(product.isHasStock());
                    val.setName(product.getName());
                    val.setPurchasePrice(product.getPurchasePrice());
                    val.setSalePrice(product.getSalePrice());
                    return val;
                })
        );

        productRepository.save(productUpdated);

        return productUpdated;

    }

    public Product delete(Long id) {
        Product productDeleted = validateOptional(productRepository.findById(id));
        productRepository.deleteById(id);
        return productDeleted;
    }

    private Product validateOptional(Optional<Product> opt) {
        if (opt.isPresent()) {
            return opt.get();
        }
        throw new ProductNotFoundException("Produto pesquisado não encontrado!");

    }


}

package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.validation.ProductNotFoundException;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

public class ProductService {
    private final ProductRepository productRepository = new ProductInMemoryRepository();
    private final ProductValidationService validationService = new ProductValidationService();

    public Product save(Product product) {
        validationService.validate(product);
        return productRepository.save(product);
    }

    public Product findTaskById(Long id) {
        return productRepository.findProductById(id)
                .orElseThrow(() -> new ProductNotFoundException("Продукт не найден, id: " + id));
    }
}

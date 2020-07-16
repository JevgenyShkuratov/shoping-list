package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.mappers.ProductMapper;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.validation.ProductNotFoundException;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

public class ProductService {
    private  ProductRepository productRepository = new ProductInMemoryRepository();
    private  ProductValidationService validationService = new ProductValidationService();
    private  ProductMapper productMapper = new ProductMapper();

    public ProductDto save(ProductDto productDto) {
        validationService.validate(productDto);
        ProductEntity entity = productMapper.toEntity(productDto);
        ProductEntity savedEntity = productRepository.save(entity);
        return productMapper.toDto(savedEntity);

    }

    public ProductEntity findTaskById(Long id) {
        return productRepository.findProductById(id)
                .orElseThrow(() -> new ProductNotFoundException("Продукт не найден, id: " + id));
    }
}

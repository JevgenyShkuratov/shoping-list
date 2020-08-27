package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.mappers.ProductMapper;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.validation.ProductNotFoundException;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductValidationService validationService;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository,
                          ProductValidationService validationService,
                          ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.validationService = validationService;
        this.productMapper = productMapper;
    }

    public ProductDto save(ProductDto productDto) {
        validationService.validate(productDto);
        ProductEntity entity = productMapper.toEntity(productDto);
        ProductEntity savedEntity = productRepository.save(entity);
        return productMapper.toDto(savedEntity);

    }

    public ProductEntity findProductById(Long id) {
        return productRepository.findProductById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found, id: " + id));
    }

    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }
}

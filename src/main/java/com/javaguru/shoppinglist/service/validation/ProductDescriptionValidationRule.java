package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;

public class ProductDescriptionValidationRule implements ProductValidationRule {

    @Override
    public void validate(ProductDto productDto) {
        checkNotNull(productDto);

        if (productDto.getDescription() == null || productDto.getDescription().isEmpty()) {
            throw new ProductValidationException("Product description must be not empty.");
        }
    }
}

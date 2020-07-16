package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;

public class ProductDescriptionRule implements ProductValidationRule {

    @Override
    public void validate(ProductDto productDto) {
        if (productDto.getDescription() == null || productDto.getDescription().isEmpty()) {
            throw new ProductValidationException("Описание продукта не должно быть пустым.");
        }
    }
}

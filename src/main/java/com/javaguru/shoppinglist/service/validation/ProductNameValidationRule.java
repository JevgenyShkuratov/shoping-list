package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;

public class ProductNameValidationRule implements ProductValidationRule {

    @Override
    public void validate(ProductDto productDto) {
        if (productDto.getName() == null) {
            throw new ProductValidationException("Имя продукта не может быть null.");
        } else {
            if (productDto.getName().length() < 3 || productDto.getName().length() > 32) {
                throw new ProductValidationException("Имя продукта должно содержать от 3 до 32 символов.");
            }
        }
    }
}
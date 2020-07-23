package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDto;

import java.math.BigDecimal;

public class ProductDiscountAllowedValidationRule implements ProductValidationRule {
    @Override
    public void validate(ProductDto productDto) {
        checkNotNull(productDto);

        if (productDto.getPrice().compareTo(BigDecimal.valueOf(19.99)) <
                productDto.getPrice().compareTo(BigDecimal.valueOf(0))) {
            throw new ProductValidationException("Discount not possible at less than 20.");
        }
    }
}
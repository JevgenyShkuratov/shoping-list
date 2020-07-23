package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDto;

import java.math.BigDecimal;

public class ProductDiscountAllowedValidationRule implements ProductValidationRule {
    @Override
    public void validate(ProductDto productDto) {
        if (productDto.getPrice().compareTo(BigDecimal.valueOf(19.99))<
        productDto.getPrice().compareTo(BigDecimal.valueOf(0))){
            throw new ProductValidationException(" Скидка не возможна при цене ниже 20 ");
        }
    }
}
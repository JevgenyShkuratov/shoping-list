package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDto;

import java.math.BigDecimal;

public class ProductDiscountValidationRule implements ProductValidationRule {
    @Override
    public void validate(ProductDto productDto) {
        if (productDto.getDiscount() == null || productDto.getDiscount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ProductValidationException("Скидка не может быть ниже нуля");
        }
        if (productDto.getDiscount().compareTo(new BigDecimal(100)) >= 0) {
            throw new ProductValidationException("Скидка не больше 100% ");
        }
    }
}
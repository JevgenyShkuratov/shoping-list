package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ProductDiscountValidationRule implements ProductValidationRule {
    @Override
    public void validate(ProductDto productDto) {
        checkNotNull(productDto);

        if (productDto.getDiscount() == null || productDto.getDiscount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ProductValidationException("Discount cannot be lower than zero.");
        }
        if (productDto.getDiscount().compareTo(new BigDecimal(100)) >= 0) {
            throw new ProductValidationException("Discount no more 100.");
        }
    }
}
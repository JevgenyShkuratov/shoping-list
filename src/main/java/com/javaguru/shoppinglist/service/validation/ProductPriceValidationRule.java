package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDto;

import java.math.BigDecimal;

public class ProductPriceValidationRule implements ProductValidationRule {

    @Override
    public void validate(ProductDto productDto) {
        checkNotNull(productDto);
        if (productDto.getPrice() == null || productDto.getPrice().compareTo(BigDecimal.ZERO) == 0) {
            throw new ProductValidationException("The price must be at least 0.");
        }
    }
}
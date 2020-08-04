package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductNameValidationRule implements ProductValidationRule {

    @Override
    public void validate(ProductDto productDto) {
        checkNotNull(productDto);

        if (productDto.getName() == null || productDto.getName().isEmpty()) {
            throw new ProductValidationException("Product name must be not null.");
        }
        if (productDto.getName().length() < 3 || productDto.getName().length() > 32) {
            throw new ProductValidationException("Product name length from 3 to 32.");
        }
    }
}

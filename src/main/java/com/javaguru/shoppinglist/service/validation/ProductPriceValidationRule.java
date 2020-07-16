package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProductPriceValidationRule implements ProductValidationRule {

    @Override
    public void validate(ProductDto productDto) {
        if (productDto.getPrice() == null || productDto.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ProductValidationException("Цена должна быть не ниже 0.");
        }
    }
}

//        if (productDto.getPrice().setScale(2, RoundingMode.HALF_EVEN).signum() < 1) {
//            throw new ProductValidationException("Цена должна быть не ниже 0.");



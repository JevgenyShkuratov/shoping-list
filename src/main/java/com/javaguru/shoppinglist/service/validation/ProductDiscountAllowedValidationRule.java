package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProductDiscountAllowedValidationRule implements ProductValidationRule {


    @Override


    public void validate(ProductDto productDto) {
        if (productDto.getPrice().compareTo(BigDecimal.valueOf(19.99)) <
                productDto.getPrice().compareTo(BigDecimal.valueOf(0))
                && productDto.getDiscount().compareTo(BigDecimal.ZERO) > 0) {
            throw new ProductValidationException(" Скидка не возможна при цене ниже 20 ");
        }
    }
}

//        if (productDto.getPrice().setScale(2, RoundingMode.HALF_EVEN).compareTo(new BigDecimal("20.00")) == -1) {
//                if (productDto.getDiscount().setScale(2, RoundingMode.HALF_EVEN).signum() != 0) {
//                throw new ProductValidationException(" Скидка не возможна при цене ниже 20 ");
//                }

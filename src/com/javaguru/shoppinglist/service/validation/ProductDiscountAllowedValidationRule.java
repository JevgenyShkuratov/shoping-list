package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProductDiscountAllowedValidationRule implements ProductValidationRule {


    @Override
    public void validate(Product product) {
        if (product.getPrice().setScale(2, RoundingMode.HALF_EVEN).compareTo(new BigDecimal("20.00")) == -1) {
            if (product.getDiscount().setScale(2, RoundingMode.HALF_EVEN).signum() != 0) {
                throw new ProductValidationException(" Скидка не возможна при цене ниже 20 ");
            }
        }

    }
}

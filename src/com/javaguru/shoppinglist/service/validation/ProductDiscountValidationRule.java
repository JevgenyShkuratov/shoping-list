package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProductDiscountValidationRule implements ProductValidationRule {
    @Override
    public void validate(Product product) {
        if (product.getDiscount().setScale(2, RoundingMode.HALF_EVEN).compareTo(new BigDecimal(100)) == 1) {
            throw new ProductValidationException("Скидка не больше 100% ");
        } else {
            if (product.getDiscount().setScale(2, RoundingMode.HALF_EVEN).signum() == -1) {
                throw new ProductValidationException("Скидка не может быть ниже нуля");
            }
        }
    }
}
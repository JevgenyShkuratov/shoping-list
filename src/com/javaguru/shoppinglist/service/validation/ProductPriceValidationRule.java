package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import java.math.RoundingMode;

public class ProductPriceValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        if (product.getPrice().setScale(2, RoundingMode.HALF_EVEN).signum() < 1) {
            throw new ProductValidationException("Цена должна быть не ниже 0.");
        }
    }
}

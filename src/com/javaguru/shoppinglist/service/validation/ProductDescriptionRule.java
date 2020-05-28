package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public class ProductDescriptionRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        if (product.getDescription() == null || product.getDescription().isEmpty()) {
            throw new ProductValidationException("Описание продукта не должно быть пустым.");
        }
    }
}

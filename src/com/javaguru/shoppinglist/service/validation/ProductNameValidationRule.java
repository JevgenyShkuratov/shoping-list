package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public class ProductNameValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        if (product.getName() == null) {
            throw new ProductValidationException("Имя продукта не может быть null.");
        } else {
            if (product.getName().length() < 3 || product.getName().length() > 32) {
                throw new ProductValidationException("Имя продукта должно содержать от 3 до 32 символов.");
            }
        }
    }
}
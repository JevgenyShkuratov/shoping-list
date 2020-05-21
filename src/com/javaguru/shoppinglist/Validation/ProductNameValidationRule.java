package com.javaguru.shoppinglist.Validation;

import com.javaguru.shoppinglist.Product;

public class ProductNameValidationRule implements ProductValidationRule {


    @Override
    public void validate(Product product) {
        if (product.getName() == null) {
            throw new ProductValidationException("Product name must be not null.");
        } else {
            if (product.getName().length() < 3 || product.getName().length() > 32) {
                throw new ProductValidationException("Only - from 3 to 32 symbol");
            }
        }
    }
}
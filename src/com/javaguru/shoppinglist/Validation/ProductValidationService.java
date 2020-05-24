package com.javaguru.shoppinglist.Validation;

import com.javaguru.shoppinglist.Product;

import java.util.HashSet;
import java.util.Set;

public class ProductValidationService {

    private Set<ProductValidationRule> validationRules = new HashSet<>();

    public ProductValidationService() {
        validationRules.add(new ProductNameValidationRule());

    }

    public void validate(Product product) {
        validationRules.forEach(s -> s.validate(product));
    }
}


package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;

import java.util.HashSet;
import java.util.Set;

public class ProductValidationService {

    private final Set<ProductValidationRule> validationRules = new HashSet<>();

    public ProductValidationService() {
        validationRules.add(new ProductNameValidationRule());
        validationRules.add(new ProductDescriptionRule());
        validationRules.add(new ProductPriceValidationRule());
        validationRules.add(new ProductDiscountValidationRule());
        validationRules.add(new ProductDiscountAllowedValidationRule());
    }

    public void validate(ProductDto productDto) {
        for (ProductValidationRule rule : validationRules) {
            rule.validate(productDto);
        }
    }
}

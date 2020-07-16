package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDto;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.*;

public class ProductDiscountAllowedValidationRuleTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    private ProductDiscountAllowedValidationRule victim = new ProductDiscountAllowedValidationRule();

    @Test
    public void productDiscountAllowed(){
        ProductDto productDto = new ProductDto();
        productDto.setDiscount(BigDecimal.ZERO);
        exception.expect(ProductValidationException.class);
        exception.expectMessage(" Скидка не возможна при цене ниже 20");
        victim.validate(productDto);
    }
}
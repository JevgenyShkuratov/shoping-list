package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDto;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class ProductDiscountValidationRuleTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private ProductDiscountValidationRule victim = new ProductDiscountValidationRule();

    @Test
    public void productDiscNull() {
        ProductDto productDto = new ProductDto();
        productDto.setDiscount(BigDecimal.ZERO);
        exception.expect(ProductValidationException.class);
        exception.expectMessage("Скидка не может быть ниже нуля");
        victim.validate(productDto);
    }
}
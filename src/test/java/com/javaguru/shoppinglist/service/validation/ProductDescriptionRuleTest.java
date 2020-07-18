package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDto;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ProductDescriptionRuleTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    private ProductDescriptionRule victim = new ProductDescriptionRule();

    @Test
    public void productDescWhenNull() {
        ProductDto productDto = new ProductDto();
        productDto.setDescription(null);
        exception.expect(ProductValidationException.class);
        exception.expectMessage("Описание продукта не должно быть пустым.");
        victim.validate(productDto);
    }
}
package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDto;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ProductPriceValidationRuleTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private ProductPriceValidationRule victim = new ProductPriceValidationRule();

    @Test
    public void productPriceWhenNull() {
        ProductDto productDto = new ProductDto();
        productDto.setPrice(BigDecimal.ZERO);
        exception.expect(ProductValidationException.class);
        exception.expectMessage("Цена должна быть не ниже 0.");
        victim.validate(productDto);
    }

}
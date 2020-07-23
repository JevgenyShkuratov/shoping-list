package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDto;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class ProductNameValidationRuleTest {

    private ProductNameValidationRule victim = new ProductNameValidationRule();

    ProductDto input = new ProductDto();

    @Test
    public void shouldProductNameValidationException() {
        input.setName("");
        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(ProductValidationException.class)
                .hasMessage("Product name must be not null.");
    }

    @Test
    public void shouldProductLengthToShort() {
        input.setName("12");
        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(ProductValidationException.class)
                .hasMessage("Product name length from 3 to 32.");
    }

    @Test
    public void shouldProductLengthToLong() {
        input.setName("123456789012345678901234567890123");
        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(ProductValidationException.class)
                .hasMessage("Product name length from 3 to 32.");

    }
}
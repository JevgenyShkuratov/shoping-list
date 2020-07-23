package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDto;
import org.junit.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


public class ProductDescriptionValidationRuleTest {

    private ProductDescriptionValidationRule victim = new ProductDescriptionValidationRule();

    ProductDto input = new ProductDto();

    @Test
    public void shouldProductNameDescription() {
        input.setDescription("");
        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(ProductValidationException.class)
                .hasMessage("Product description must be not empty.");
    }
}
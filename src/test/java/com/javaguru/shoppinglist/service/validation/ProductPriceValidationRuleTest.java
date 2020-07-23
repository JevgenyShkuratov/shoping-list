package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDto;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ProductPriceValidationRuleTest {

    private ProductPriceValidationRule victim = new ProductPriceValidationRule();

    ProductDto input = new ProductDto();

    @Test
    public void shouldProductPriceValidation() {
        input.setPrice(BigDecimal.ZERO);
        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(ProductValidationException.class)
                .hasMessage("The price must be at least 0.");
    }

}
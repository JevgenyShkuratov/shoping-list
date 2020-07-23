package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDto;
import org.junit.Test;
import java.math.BigDecimal;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


public class ProductDiscountAllowedValidationRuleTest {

    private ProductDiscountAllowedValidationRule victim = new ProductDiscountAllowedValidationRule();

    ProductDto input = new ProductDto();

    @Test
    public void shouldProductDiscountAllowed() {
        input.setPrice(new BigDecimal(19.99));
        input.setPrice(new BigDecimal(0));
        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(ProductValidationException.class)
                .hasMessage("Discount not possible at less than 20.");
    }
}
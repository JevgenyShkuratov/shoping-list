package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDto;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class ProductDiscountValidationRuleTest {

    private ProductDiscountValidationRule victim = new ProductDiscountValidationRule();

    ProductDto input = new ProductDto();

    @Test
    public void shouldDiscountValidation() {
        input.setDiscount(BigDecimal.ZERO);
        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(ProductValidationException.class)
                .hasMessage("Discount cannot be lower than zero.");
    }

    @Test
    public void shouldDiscountNoMoreValidation() {
        input.setDiscount(new BigDecimal(100));
        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(ProductValidationException.class)
                .hasMessage("Discount no more 100.");
    }
}

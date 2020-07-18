package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDto;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ProductNameValidationRuleTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    private ProductNameValidationRule victim = new ProductNameValidationRule();

    @Test
    public void productNameWhenNull() {
        ProductDto productDto = new ProductDto();
        productDto.setName(null);
        exception.expect(ProductValidationException.class);
        exception.expectMessage("Имя продукта не может быть null.");
        victim.validate(productDto);
    }

    @Test
    public void productLengthToShort() {
        ProductDto productDto = new ProductDto();
        productDto.setName("12");
        exception.expect(ProductValidationException.class);
        exception.expectMessage("Имя продукта должно содержать от 3 до 32 символов.");
        victim.validate(productDto);
    }

    @Test
    public void productLengthToLong() {
        ProductDto productDto = new ProductDto();
        productDto.setName("123456789012345678901234567890123");
        exception.expect(ProductValidationException.class);
        exception.expectMessage("Имя продукта должно содержать от 3 до 32 символов.");
        victim.validate(productDto);
    }

}


//
//    ProductNameValidationRule validationRule = new ProductNameValidationRule();
//    ProductDto victim = new ProductDto();
//
//    @Test
//    public void productIsNull() throws Exception {
//        victim.setName(null);
//        try {
//            validationRule.validate(victim);
//            fail();
//        } catch (
//                Exception e) {
//            assertEquals(e.getMessage(), "Имя продукта не может быть null.");
//        }
//
//    }

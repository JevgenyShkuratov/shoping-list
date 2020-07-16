package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProductDiscountValidationRule implements ProductValidationRule {
    @Override
    public void validate(ProductDto productDto) {
        if (productDto.getDiscount() == null || productDto.getDiscount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ProductValidationException("Скидка не может быть ниже нуля");
        }
        if (productDto.getDiscount().compareTo(new BigDecimal(100)) >= 0) {
            throw new ProductValidationException("Скидка не больше 100% ");
        }
    }
}
//  if (productDto.getDiscount().setScale(2, RoundingMode.HALF_EVEN).compareTo(new BigDecimal(100)) == 1) {
//          throw new ProductValidationException("Скидка не больше 100% ");
//          } else {
//          if (productDto.getDiscount().setScale(2, RoundingMode.HALF_EVEN).signum() == -1) {
//          throw new ProductValidationException("Скидка не может быть ниже нуля");
//          }
//          }
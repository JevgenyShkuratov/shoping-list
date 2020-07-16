package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDto;

public interface ProductValidationRule {

    void validate(ProductDto productDto);


}

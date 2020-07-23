package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.console.ConsoleUI;
import com.javaguru.shoppinglist.mappers.ProductMapper;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.validation.*;

import java.util.HashSet;
import java.util.Set;

public class ShoppingListApplication {

    public static void main(String[] args) {
        ProductRepository repository = new ProductInMemoryRepository();

        Set<ProductValidationRule> rules = new HashSet<>();
        rules.add(new ProductDescriptionValidationRule());
        rules.add(new ProductDiscountAllowedValidationRule());
        rules.add(new ProductDiscountValidationRule());
        rules.add(new ProductNameValidationRule());
        rules.add(new ProductPriceValidationRule());
        rules.add(new ProductUniqueNameValidationRule(repository));

        ProductValidationService validationService = new ProductValidationService(rules);
        ProductMapper productMapper = new ProductMapper();
        ProductService service = new ProductService(repository, validationService, productMapper);
        ConsoleUI ui = new ConsoleUI(service);
        ui.start();
    }
}
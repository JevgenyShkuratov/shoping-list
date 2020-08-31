package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(3)
@Component
public class FindAllProductAction implements MenuAction {

    private final ProductService productService;

    public FindAllProductAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {

        productService.findAll()
                .forEach(System.out::println);
    }

    @Override
    public String getMenuActionName() {
        return "Find All Product";
    }
}

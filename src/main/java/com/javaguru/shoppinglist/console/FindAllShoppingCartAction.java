package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.service.ShoppingCartService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Order(5)
public class FindAllShoppingCartAction implements MenuAction {

    private final ShoppingCartService shoppingCartService;

    public FindAllShoppingCartAction(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public void execute() {
        shoppingCartService.findAllShoppingCart()
                .forEach(System.out::println);
    }

    @Override
    public String getMenuActionName() {
        return "Find All Shopping cart";
    }
}

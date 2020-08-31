package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.ShoppingCartEntity;
import com.javaguru.shoppinglist.service.ShoppingCartService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Order(4)
public class CreateShoppingCartAction implements MenuAction {


    private final ShoppingCartService shoppingCartService;

    public CreateShoppingCartAction(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public void execute() {
        System.out.println("Please enter shopping cart name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        ShoppingCartEntity shoppingCart = new ShoppingCartEntity();
        shoppingCart.setName(name);

        ShoppingCartEntity createdShoppingCart = shoppingCartService.save(shoppingCart);
        System.out.println("Shopping cart created " + createdShoppingCart);

    }

    @Override
    public String getMenuActionName() {
        return "Create shopping cart";
    }
}

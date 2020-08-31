package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.ShoppingCartService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Scanner;

@Component
@Order(6)
public class AddProductToShoppingCart implements MenuAction {

    private final ShoppingCartService shoppingCartService;
    private final ProductService productService;

    public AddProductToShoppingCart(ShoppingCartService shoppingCartService, ProductService productService) {
        this.shoppingCartService = shoppingCartService;
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter product id: ");
        Long productId = scanner.nextLong();
        System.out.println("Please enter shopping cart id ");

        Long shoppingCartId = scanner.nextLong();
        ProductEntity product = productService.findProductById(productId);
        shoppingCartService.addProduct(product, shoppingCartId);


    }

    @Override
    public String getMenuActionName() {
        return "Add product to shopping cart";
    }
}

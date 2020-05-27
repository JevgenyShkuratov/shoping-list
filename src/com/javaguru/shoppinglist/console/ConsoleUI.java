package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.validation.ProductNotFoundException;
import com.javaguru.shoppinglist.service.validation.ProductValidationException;

import java.math.BigDecimal;
import java.util.Scanner;

public class ConsoleUI {

    private ProductService service = new ProductService();

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Exit");
                Integer userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        System.out.println("Введите наименование продукта: ");
                        String name = scanner.nextLine();
                        System.out.println("Введите описание: ");
                        String description = scanner.nextLine();
                        System.out.println("Введите цену: ");
                        BigDecimal price = new BigDecimal(scanner.nextLine());
                        System.out.println("Введите скидку: ");
                        BigDecimal discount = new BigDecimal(scanner.nextLine());
                        System.out.println("Введите категорию: ");
                        String category = scanner.nextLine();

                        Product product = new Product(name, description, price, discount, category);
                        Product createdProduct = service.save(product);
                        System.out.println("Product + " + createdProduct);
                        break;
                    case 2:
                        System.out.println("Enter product id : ");
                        Long id = Long.valueOf(scanner.nextLine());
                        Product product1 = service.findTaskById(id);
                        System.out.println("Product found: " + product1);
                        break;
                    case 3:
                        return;
                }
            } catch (ProductValidationException e) {
                System.out.println("Product validation failed. Message " + e.getMessage());
            } catch (ProductNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Что пошло не так Error.");
            }
        }
    }
}
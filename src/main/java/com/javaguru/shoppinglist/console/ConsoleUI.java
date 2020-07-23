package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
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
                        createProduct();
                        break;
                    case 2:
                        findProduct();
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

    public void createProduct() {
        Scanner scanner = new Scanner(System.in);
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
        ProductDto dto = new ProductDto();
        dto.setName(name);
        dto.setDescription(description);
        dto.setPrice(new BigDecimal(String.valueOf(price)));
        dto.setDiscount(new BigDecimal(String.valueOf(discount)));
        dto.setCategory(category);

        ProductDto productDto = service.save(dto);
        System.out.println("Product + " + productDto);
    }

    public void findProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id : ");
        Long id = Long.valueOf(scanner.nextLine());
        ProductEntity productEntity1 = service.findTaskById(id);
        System.out.println("Product found: " + productEntity1);
    }
}
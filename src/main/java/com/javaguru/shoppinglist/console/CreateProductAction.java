package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
@Order(0)
public class CreateProductAction implements MenuAction {

    private final ProductService service;

    public CreateProductAction(ProductService service) {
        this.service = service;
    }

    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product: ");
        String name = scanner.nextLine();
        System.out.println("Enter description: ");
        String description = scanner.nextLine();
        System.out.println("Enter price: ");
        BigDecimal price = new BigDecimal(scanner.nextLine());
        System.out.println("Enter discount: ");
        BigDecimal discount = new BigDecimal(scanner.nextLine());
        System.out.println("Enter category: ");
        String category = scanner.nextLine();
        ProductDto dto = new ProductDto();
        dto.setName(name);
        dto.setDescription(description);
        dto.setPrice(new BigDecimal(String.valueOf(price)));
        dto.setDiscount(new BigDecimal(String.valueOf(discount)));
        dto.setCategory(category);

        ProductDto productDto = service.save(dto);
        System.out.println("Product successfully created: " + productDto);
    }

    @Override
    public String toString() {
        return "Create product";
    }
}

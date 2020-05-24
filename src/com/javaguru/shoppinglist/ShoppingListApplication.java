package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.Validation.ProductNameValidationRule;
import com.javaguru.shoppinglist.Validation.ProductValidationRule;
import com.javaguru.shoppinglist.Validation.ProductValidationService;
import jdk.jfr.Category;

import javax.xml.namespace.QName;
import java.math.BigDecimal;
import java.util.*;

class ShoppingListApplication {

    public static void main(String[] args) {
        Map<Long, Product> productRepository = new HashMap<>();
        Long productIdSequence = 0L;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Exit");
                Integer userInput = Integer.valueOf(scanner.nextLine());

                switch (userInput) {
                    case 1:
                        System.out.println("Enter product name: ");
                        String name = scanner.nextLine();

                        System.out.println("Enter product price: ");
                        BigDecimal price = new BigDecimal(scanner.nextLine());

                        System.out.println("Enter product discount: ");
                        BigDecimal discount = new BigDecimal(scanner.nextLine());

                        System.out.println("Enter product description: ");
                        String description = scanner.nextLine();

                        System.out.println("Enter product category: ");
                        String category = scanner.nextLine();

                        Product product = new Product();
                        product.setName(name);
                        product.setPrice(price);
                        product.setDiscount(discount);
                        product.setDescription(description);
                        product.setCategory(category);

                        product.setId(productIdSequence);
                        productRepository.put(productIdSequence, product);
                        productIdSequence++;
                        System.out.println("Result: " + product.getId());
                        Set<ProductValidationRule> rules = new HashSet<>();
                        rules.add(new ProductNameValidationRule());
                        ProductValidationService productValidationService = new ProductValidationService();
                        productValidationService.validate(product);

                    case 2:
                        System.out.println("Enter product id: ");
                        long id = scanner.nextLong();
                        Product findProductResult = productRepository.get(id);

                        System.out.println(findProductResult); // ?
                    case 3:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
            }
        }
    }
}

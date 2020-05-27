package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ProductInMemoryRepository implements ProductRepository {

    private final Map<Long, Product> repository = new HashMap<>();
    private Long productIdSequence = 0L;


    @Override
    public Product save(Product product) {
        Product productCopy = new Product(productIdSequence++,
                product.getName(), product.getDescription(),
                product.getPrice(), product.getDiscount(),
                product.getCategory());
        repository.put(productCopy.getId(), productCopy);
        return productCopy;
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        return Optional.ofNullable(repository.get(id));

    }
}

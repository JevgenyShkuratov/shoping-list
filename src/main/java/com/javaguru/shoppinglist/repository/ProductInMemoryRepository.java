package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.ProductEntity;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@Profile("inmemory")
public class ProductInMemoryRepository implements ProductRepository {

    private final Map<Long, ProductEntity> repository = new HashMap<>();
    private Long productIdSequence = 0L;

    @Override
    public ProductEntity save(ProductEntity productEntity) {
        ProductEntity productEntityCopy = new ProductEntity(productIdSequence++,
                productEntity.getName(), productEntity.getDescription(),
                productEntity.getPrice(), productEntity.getDiscount(),
                productEntity.getCategory());
        repository.put(productEntityCopy.getId(), productEntityCopy);
        return productEntityCopy;
    }

    @Override
    public Optional<ProductEntity> findProductById(Long id) {
        return Optional.ofNullable(repository.get(id));
    }

    @Override
    public Optional<ProductEntity> findProductByName(String name) {
        return repository.values().stream()
                .filter(entity -> entity.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    @Override
    public List<ProductEntity> findAll() {
        return null;
    }
}

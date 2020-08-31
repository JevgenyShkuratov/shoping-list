package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.domain.ShoppingCartEntity;
import com.javaguru.shoppinglist.repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public ShoppingCartEntity save(ShoppingCartEntity shoppingCartEntity) {
        return shoppingCartRepository.save(shoppingCartEntity);
    }

    public List<ShoppingCartEntity> findAllShoppingCart() {
        return shoppingCartRepository.findAll();
    }

    public void addProduct(ProductEntity productEntity, Long shoppingCartId) {
        ShoppingCartEntity shoppingCart = findById(shoppingCartId)
                .orElseThrow(() -> new IllegalArgumentException("Shopping cart noy found by Id: " + shoppingCartId));
        shoppingCart.getProducts().add(productEntity);
        shoppingCartRepository.update(shoppingCart);
    }

    private Optional<ShoppingCartEntity> findById(Long shoppingCartId) {
        return shoppingCartRepository.findById(shoppingCartId);
    }

}
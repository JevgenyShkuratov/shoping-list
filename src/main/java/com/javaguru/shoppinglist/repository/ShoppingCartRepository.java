package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.ShoppingCartEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShoppingCartRepository {

    ShoppingCartEntity save(ShoppingCartEntity shoppingCartEntity);

    Optional<ShoppingCartEntity> findById(Long id);

    List<ShoppingCartEntity> findAll();

    void update(ShoppingCartEntity shoppingCartEntity);
}

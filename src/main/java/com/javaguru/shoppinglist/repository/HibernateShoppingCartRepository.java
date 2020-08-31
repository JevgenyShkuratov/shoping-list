package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.ShoppingCartEntity;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class HibernateShoppingCartRepository implements ShoppingCartRepository {

    private final SessionFactory sessionFactory;

    public HibernateShoppingCartRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public ShoppingCartEntity save(ShoppingCartEntity shoppingCartEntity) {
        sessionFactory.getCurrentSession().save(shoppingCartEntity);
        return shoppingCartEntity;
    }

    @Override
    public Optional<ShoppingCartEntity> findById(Long id) {
        ShoppingCartEntity shoppingCartEntity = sessionFactory.getCurrentSession().find(ShoppingCartEntity.class, id);
        return Optional.ofNullable(shoppingCartEntity);
    }

    @Override
    public List<ShoppingCartEntity> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(ShoppingCartEntity.class).list();
    }

    @Override
    public void update(ShoppingCartEntity shoppingCartEntity) {
        sessionFactory.getCurrentSession().update(shoppingCartEntity);
    }
}

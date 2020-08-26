package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.ProductEntity;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Profile("hibernate")
@Transactional
public class HibernateProductRepository implements ProductRepository {

    private final SessionFactory sessionFactory;

    public HibernateProductRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public ProductEntity save(ProductEntity productEntity) {
        sessionFactory.getCurrentSession().save(productEntity);
        return productEntity;
    }

    @Override
    public Optional<ProductEntity> findProductById(Long id) {
        ProductEntity product = (ProductEntity) sessionFactory.getCurrentSession().createCriteria(ProductEntity.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        return Optional.ofNullable(product);
    }

    @Override
    public Optional<ProductEntity> findProductByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<ProductEntity> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(ProductEntity.class).list();
    }
}

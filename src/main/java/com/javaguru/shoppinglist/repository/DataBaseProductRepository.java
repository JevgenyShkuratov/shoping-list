package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.mappers.ProductEntityRowMapper;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
@Profile("mysql")
public class DataBaseProductRepository implements ProductRepository {

    private final JdbcTemplate jdbcTemplate;

    public DataBaseProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ProductEntity save(ProductEntity productEntity) {
        String query = "INSERT INTO product (name,description,price,discount,category) VALUES (?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, productEntity.getName());
            preparedStatement.setString(2, productEntity.getDescription());
            preparedStatement.setBigDecimal(3, productEntity.getPrice());
            preparedStatement.setBigDecimal(4, productEntity.getDiscount());
            preparedStatement.setString(5, productEntity.getCategory());
            return preparedStatement;
        }, keyHolder);
        return new ProductEntity(
                keyHolder.getKey().longValue(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getPrice(),
                productEntity.getDiscount(),
                productEntity.getCategory()
        );
    }

    @Override
    public Optional<ProductEntity> findProductById(Long id) {
        String query = "SELECT * FROM product WHERE id = ?";
        ProductEntity productEntity = jdbcTemplate.queryForObject(query, new Object[]{id}, new ProductEntityRowMapper());
        return Optional.ofNullable(productEntity);
    }

    @Override
    public Optional<ProductEntity> findProductByName(String name) {
        String query = "SELECT * FROM product WHERE name=" + name;
        ProductEntity productEntity = jdbcTemplate.queryForObject(query, new ProductEntityRowMapper());
        return Optional.ofNullable(productEntity);
    }

    @Override
    public List<ProductEntity> findAll() {
        String query = "SELECT * FROM product";
        return jdbcTemplate.query(query, new ProductEntityRowMapper());
    }


}

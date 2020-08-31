package com.javaguru.shoppinglist.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "discount")
    private BigDecimal discount;

    @Column(name = "category")
    private String category;

    @Column(name = "shopping_Cart_id")
    private Long shopping_Cart_id;

    public ProductEntity() {
    }

    public ProductEntity(Long id, String name, String description, BigDecimal price, BigDecimal discount, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.category = category;

    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity entity = (ProductEntity) o;
        return Objects.equals(id, entity.id) &&
                Objects.equals(name, entity.name) &&
                Objects.equals(description, entity.description) &&
                Objects.equals(price, entity.price) &&
                Objects.equals(discount, entity.discount) &&
                Objects.equals(category, entity.category) &&
                Objects.equals(shopping_Cart_id, entity.shopping_Cart_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, discount, category, shopping_Cart_id);
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", category='" + category + '\'' +
                ", shopping_Cart_id=" + shopping_Cart_id +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public String getCategory() {
        return category;
    }

    public Long getShopping_Cart_id() {
        return shopping_Cart_id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setShopping_Cart_id(Long shopping_Cart_id) {
        this.shopping_Cart_id = shopping_Cart_id;
    }
}
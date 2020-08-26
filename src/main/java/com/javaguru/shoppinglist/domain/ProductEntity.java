package com.javaguru.shoppinglist.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Long id;

    @Column(name = "name")
    private  String name;

    @Column(name = "description")
    private  String description;

    @Column(name = "price")
    private  BigDecimal price;

    @Column(name = "discount")
    private  BigDecimal discount;
    
    @Column(name = "category")
    private  String category;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity productEntity = (ProductEntity) o;
        return Objects.equals(getId(), productEntity.getId()) &&
                Objects.equals(getName(), productEntity.getName()) &&
                Objects.equals(getDescription(), productEntity.getDescription()) &&
                Objects.equals(getPrice(), productEntity.getPrice()) &&
                Objects.equals(getDiscount(), productEntity.getDiscount()) &&
                Objects.equals(getCategory(), productEntity.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getPrice(), getDiscount(), getCategory());
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", category='" + category + '\'' +
                '}';
    }
}
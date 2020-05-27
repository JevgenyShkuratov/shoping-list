package com.javaguru.shoppinglist.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private BigDecimal discount;
    private String category;


    public Product(Long id, String name, String description, BigDecimal price, BigDecimal discount, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.category = category;

    }

    public Product(String name, String description, BigDecimal price, BigDecimal discount, String category) {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(getId(), product.getId()) &&
                Objects.equals(getName(), product.getName()) &&
                Objects.equals(getDescription(), product.getDescription()) &&
                Objects.equals(getPrice(), product.getPrice()) &&
                Objects.equals(getDiscount(), product.getDiscount()) &&
                Objects.equals(getCategory(), product.getCategory());
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
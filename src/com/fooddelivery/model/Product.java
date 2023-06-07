package com.fooddelivery.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Product {

    private UUID productId;
    private String name;
    private String description;
    private Double cost;
    private List<Restaurant> restaurants;

    public Product(){}
    public Product(String name, String description, Double cost) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.productId = UUID.randomUUID();
        this.restaurants = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public UUID getProductId() {
        return this.productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(cost, product.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, cost);
    }

    @Override
    public String toString() {
        return this.name + ": " + this.description + ". Pret: " + this.cost + " lei.";
    }
}

package com.fooddelivery.service;

import com.fooddelivery.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductService {

    private List<Product> products;

    public ProductService() {
        products = new ArrayList<>();
    }

    public void addProduct(String name, String description, Double cost) {
        Product product = new Product(name, description, cost);
        products.add(product);
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(UUID productId) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    public void updateProduct(UUID productId, String newName, String newDescription, Double newCost) {
        Product product = getProductById(productId);
        if (product != null) {
            product.setName(newName);
            product.setDescription(newDescription);
            product.setCost(newCost);
        }
    }

    public void deleteProduct(UUID productId) {
        Product product = getProductById(productId);
        if (product != null) {
            products.remove(product);
        }
    }

}

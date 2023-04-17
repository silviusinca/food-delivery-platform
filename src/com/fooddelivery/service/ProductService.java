package com.fooddelivery.service;

import com.fooddelivery.model.Product;

import java.util.HashMap;

public class ProductService {
    private HashMap<Product, Integer> products; // key = produs, value = cantitate

    public void addProduct(Product product, Integer quantity) {
        products.put(product, quantity);
    }

    public void updateProductQuantity(Product product, Integer quantity) {
        products.replace(product, products.get(product) - quantity);
    }

    public void deleteProduct(Product product) {
        products.remove(product);
    }
}

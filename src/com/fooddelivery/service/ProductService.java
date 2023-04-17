package com.fooddelivery.service;

import com.fooddelivery.model.Product;

import java.util.HashMap;

public class ProductService {
    private HashMap<Product, Integer> products; // key = produs, value = cantitate

    public void addProduct(Product product) {
        products.put(product, 1);
    }

    public void addProducts(Product product, Integer quantity) {
        products.put(product, quantity);
    }

    public void deleteOneProduct(Product product) {
        products.replace(product, products.get(product) - 1);
    }

    public void deleteMultipleProducts(Product product, Integer quantity) {
        products.replace(product, products.get(product) - quantity);
    }

    public void eliminateProduct(Product product) {
        products.remove(product);
    }
}

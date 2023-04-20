package com.fooddelivery.model;

import com.fooddelivery.service.ProductService;

import java.util.HashMap;
import java.util.Objects;

public class Restaurant {
    private Address address;
    private HashMap<Product, Integer> menu; // key = produs si value = cantitatea disponibila
    private final ProductService productService;


    public Restaurant(Address address, ProductService productService) {
        this.address = address;
        this.productService = productService;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public HashMap<Product, Integer> getMenu() {
        return menu;
    }

    public void addProductToMenu(Product product, Integer quantity) {
        this.menu.put(product, quantity);
        productService.addProduct(product, quantity);
    }

    public void deleteProductFromMenu(Product product) {
        this.menu.remove(product);
        productService.deleteProduct(product);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                address.toString() +
                ", products=" + menu.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return Objects.equals(address, that.address) && Objects.equals(menu, that.menu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, menu);
    }
}

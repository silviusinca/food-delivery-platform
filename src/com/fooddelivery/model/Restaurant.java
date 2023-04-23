package com.fooddelivery.model;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class Restaurant {

    private UUID restaurantId;
    private Address address;
    private String restaurantName;
    private HashMap<Product, Integer> menu; // key = produs si value = cantitatea disponibila

    public Restaurant(String restaurantName, Address address, HashMap<Product, Integer> menu) {
        this.restaurantName = restaurantName;
        this.address = address;
        this.menu = menu;
        this.restaurantId = UUID.randomUUID();
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
    }

    public void deleteProductFromMenu(Product product) {
        this.menu.remove(product);
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public void setMenu(HashMap<Product, Integer> menu) {
        this.menu = menu;
    }

    public UUID getRestaurantId() {
        return restaurantId;
    }

    @Override
    public String toString() {
        return  this.restaurantName + "{" +
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
        return Objects.hash(restaurantName, address, menu);
    }
}

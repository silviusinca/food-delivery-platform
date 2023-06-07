package com.fooddelivery.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class Restaurant {

    private UUID restaurantId;
    private Address address;
    private String restaurantName;
    private ArrayList<Product> menu; // key = produs si value = cantitatea disponibila
    private ArrayList<Review> reviews;

    public Restaurant(String restaurantName, Address address) {
        this.restaurantName = restaurantName;
        this.address = address;
        this.menu = new ArrayList<>();
        this.restaurantId = UUID.randomUUID();
    }

    public Restaurant(){}

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ArrayList<Product> getMenu() {
        return menu;
    }

    public void addProductToMenu(Product product) {
        this.menu.add(product);
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

    public void setMenu(ArrayList<Product> menu) {
        this.menu = menu;
    }

    public UUID getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(UUID restaurantId) {
        this.restaurantId = restaurantId;
    }


    @Override
    public String toString() {
        return "Restaurantul " + this.restaurantName + " se afla la adresa " + this.address + " si are urmatorul meniu: \n" + printMenu();
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

    public String printMenu() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < menu.size(); i++) {
            str.append(i+1).append(". ").append(menu.get(i)).append("\n");
        }

        return str.toString();
    }
}

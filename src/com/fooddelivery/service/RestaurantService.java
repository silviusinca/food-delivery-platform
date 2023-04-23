package com.fooddelivery.service;

import com.fooddelivery.model.Restaurant;

import java.util.ArrayList;

public class RestaurantService {
    private ArrayList<Restaurant> restaurants;

    public RestaurantService() {
        this.restaurants = new ArrayList<>();
    }

    public void addRestaurant(Restaurant restaurant) {
        this.restaurants.add(restaurant);
    }

    public Restaurant getRestaurantByName(String name) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getRestaurantName().equals(name)) {
                return restaurant;
            }
        }
        return null;
    }
}

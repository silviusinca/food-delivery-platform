package com.fooddelivery.service;

import com.fooddelivery.model.Restaurant;

import java.util.ArrayList;

public class RestaurantService {
    private static final ArrayList<Restaurant> restaurants = new ArrayList<>();

    public static void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public static Restaurant getRestaurantByName(String name) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getRestaurantName().equals(name)) {
                return restaurant;
            }
        }
        return null;
    }

    public static ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }

    public static void listRestaurants() {
        for (int i = 0; i < restaurants.size(); i++) {
            System.out.println(i+1 + " " + restaurants.get(i));
            System.out.println();
        }
    }
}

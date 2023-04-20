package com.fooddelivery.service;

import com.fooddelivery.model.*;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private List<Order> orders = new ArrayList<>();

    public Order createOrder(Client client, List<Product> products, Restaurant restaurant) {}

    public void assignOrder(Order order, Driver driver){
        // logic to assign order to driver
    }

}

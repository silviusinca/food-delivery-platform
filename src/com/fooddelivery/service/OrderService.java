package com.fooddelivery.service;

import com.fooddelivery.model.*;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
//    private List<Order> orders = new ArrayList<>();

    // voi simula procesul de asteptare pentru prepararea order-ului etc. si voi lua valori random intre 0-5 secunde pentru fiecare etapa din OrderStatus

    public Order createOrder(Client client, Driver driver, ArrayList<Product> products, Restaurant restaurant) {
        Order newOrder = new Order();

        newOrder.setClient(client);
        newOrder.setDriver(driver);
        newOrder.setRestaurant(restaurant);
        newOrder.setProductList(products);

        return newOrder;
    }

}

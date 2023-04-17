package com.fooddelivery.model;

import com.fooddelivery.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private Client client;
    private Restaurant restaurant;
    private ArrayList<Product> productList;
    private OrderStatus orderStatus;
    private LocalDateTime orderDate;
}

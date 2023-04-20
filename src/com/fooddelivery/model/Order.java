package com.fooddelivery.model;

import com.fooddelivery.enums.OrderStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {
    private static long nextId = 0;

    private long orderId;
    private Client client;
    private Restaurant restaurant;
    private ArrayList<Product> productList;
    private OrderStatus orderStatus;
    private Double price;
    private String orderDate;

    public Order(Client client, Restaurant restaurant, ArrayList<Product> productList, OrderStatus orderStatus, Double price) {
        this.orderId = nextId++;
        this.client = client;
        this.restaurant = restaurant;
        this.productList = productList;
        this.orderStatus = orderStatus;
        this.price = price;
        this.orderDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")); // pentru a formata data
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public long getOrderId() {
        return orderId;
    }
}

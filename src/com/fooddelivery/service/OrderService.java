package com.fooddelivery.service;

import com.fooddelivery.enums.OrderStatus;
import com.fooddelivery.helper.Helper;
import com.fooddelivery.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class OrderService {

    ArrayList<Order> orders = new ArrayList<>();

    // return null if order not found by id; otherwise return order;
    public Order getOrderById(UUID orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null;
    }

    // voi simula procesul de asteptare pentru prepararea order-ului etc. si voi lua valori random intre 0-5 secunde pentru fiecare etapa din OrderStatus
    public void createOrder(Client client, HashMap<Product, Integer> basket, Restaurant restaurant) throws InterruptedException {
        Order newOrder = new Order();

        this.orders.add(newOrder);

        newOrder.setClient(client);
        newOrder.setRestaurant(restaurant);
        newOrder.setBasket(basket);

        int minWait = 500, maxWait = 9000; // intre 0.5 secunde si 9 secunde

        newOrder.setOrderStatus(OrderStatus.ACCEPTED);
        System.out.println("We are happy to announce you that your order was accepted! It's going to start being prepared in no time!");
        Thread.sleep(ThreadLocalRandom.current().nextInt(minWait, maxWait + 1));

        newOrder.setOrderStatus(OrderStatus.PREPARING);
        System.out.println("Your order is being prepared!");
        Thread.sleep(ThreadLocalRandom.current().nextInt(minWait, maxWait + 1));

        newOrder.setOrderStatus(OrderStatus.READY);
        System.out.println("Your order is ready! We are going to find the best driver to deliver it to you!");
        Thread.sleep(ThreadLocalRandom.current().nextInt(minWait, maxWait + 1));

        newOrder.setOrderStatus(OrderStatus.FOUND_DRIVER);
        System.out.println("A driver has been picked to handle your order!");
        Thread.sleep(ThreadLocalRandom.current().nextInt(minWait, maxWait + 1));

        Driver driver = Helper.getRandomDriver();
        newOrder.setDriver(driver);

        newOrder.setOrderStatus(OrderStatus.PICKED_UP);
        System.out.println("Our driver, " + driver.getName() + ", picked up the order! They are coming right away!");
        Thread.sleep(ThreadLocalRandom.current().nextInt(minWait * 10, maxWait + 1));

        newOrder.setOrderStatus(OrderStatus.DELIVERED);
        System.out.println("Thank you for using our app! Enjoy your food and don't forget to rate your driver!");
    }


    /// TO BE IMPLEMENTED
    public UUID cancelOrder(UUID orderId) { // return id of cancelled order
        Order order = getOrderById(orderId);
        order.setOrderStatus(OrderStatus.CANCELLED);

        return orderId;
    }

}

package com.fooddelivery;

import com.fooddelivery.helper.Helper;
import com.fooddelivery.model.Address;
import com.fooddelivery.model.Client;
import com.fooddelivery.model.Product;
import com.fooddelivery.model.Restaurant;
import com.fooddelivery.service.OrderService;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Client client = new Client("Silviu", "0749174373", "silviu@mail.com", new Address("Biruintei 45"));

        OrderService orderService = new OrderService();
//        orderService.createOrder(client, null, null);

        ArrayList<Restaurant> restaurants = Helper.loadRestaurants();

        for (Restaurant rest : restaurants) {
            for (Product product : rest.getMenu().keySet()) {
                System.out.println(product);
            }
        }


    }
}

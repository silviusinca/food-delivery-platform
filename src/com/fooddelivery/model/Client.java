package com.fooddelivery.model;

import java.util.ArrayList;
import java.util.UUID;

public class Client extends Person {
    private final UUID clientId;
    private Address address;
    private ArrayList<Order> pastOrders;

    public Client(String name, String phoneNumber, String email, Address address) {
        super(name, phoneNumber, email);
        this.address = address;
        this.clientId = UUID.randomUUID();
    }

    public Client() {
        this.clientId = UUID.randomUUID();
    }

    public UUID getClientId() {
        return clientId;
    }

    public void addToPastOrders(Order newOrder) {
        this.pastOrders.add(newOrder);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + getName() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", " + address.toString() + '\'' +
                '}';
    }

}

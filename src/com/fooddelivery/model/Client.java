package com.fooddelivery.model;

import java.util.ArrayList;

public class Client extends Person {
    private static long nextId = 0;
    private long clientId;
    private Address address;
    private ArrayList<Order> pastOrders;

    public Client(String name, String phoneNumber, String email, Address address) {
        super(name, phoneNumber, email);
        this.address = address;
        this.clientId = nextId++;
    }

    public Client() {
        this.clientId = nextId++;
    }

    public long getClientId() {
        return clientId;
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

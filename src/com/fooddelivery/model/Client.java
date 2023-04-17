package com.fooddelivery.model;

import java.util.ArrayList;

public class Client extends Person {

    private Address address;
    private ArrayList<Order> pastOrders;

    public Client(String name, String phoneNumber, String email, Address address) {
        super(name, phoneNumber, email);
        this.address = address;
    }

    public Client() {
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

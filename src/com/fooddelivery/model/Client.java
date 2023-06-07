package com.fooddelivery.model;

import java.util.ArrayList;
import java.util.UUID;

public class Client extends Person {
    private final UUID clientId;
    private Address address;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

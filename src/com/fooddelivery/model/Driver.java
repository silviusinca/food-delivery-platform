package com.fooddelivery.model;

import java.util.UUID;

public class Driver extends Person {
    private final UUID driverId;
    private Double stars; // numarul de stele pe care il are livratorul pe platforma

    public Driver(String name, String phoneNumber, String email, Double stars) {
        super(name, phoneNumber, email);
        this.stars = stars;
        this.driverId = UUID.randomUUID();
    }

    public Double getStars() {
        return stars;
    }

    public void setStars(Double stars) {
        this.stars = stars;
    }

    public UUID getDriverId() {
        return driverId;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + getName() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", stars='" + stars + '\'' +
                '}';
    }

}

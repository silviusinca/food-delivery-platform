package com.fooddelivery.model;

public class Driver extends Person {
    private Order order;
    private Double stars; // numarul de stele pe care il are livratorul pe platforma

    public Driver(String name, String phoneNumber, String email, Double stars) {
        super(name, phoneNumber, email);
        this.stars = stars;
    }

    public Double getStars() {
        return stars;
    }

    public void setStars(Double stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + getName() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", stars='" + stars + '\'' +
                '}';
    }

}

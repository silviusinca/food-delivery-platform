package com.fooddelivery.service;

import com.fooddelivery.model.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DriverService {
    private List<Driver> drivers;

    public DriverService() {
        drivers = new ArrayList<>();
    }

    public void addDriver(String name, String phoneNumber, String email, Double stars) {
        Driver driver = new Driver(name, phoneNumber, email, stars);
        drivers.add(driver);
    }

    public List<Driver> getAllDrivers() {
        return drivers;
    }

    public Driver getDriverById(UUID driverId) {
        for (Driver driver : drivers) {
            if (driver.getDriverId().equals(driverId)) {
                return driver;
            }
        }
        return null;
    }

    public void deleteDriver(UUID driverId) {
        Driver driver = getDriverById(driverId);
        if (driver != null) {
            drivers.remove(driver);
        }
    }
}
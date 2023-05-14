package com.fooddelivery.helper;

import com.fooddelivery.model.Address;
import com.fooddelivery.model.Driver;
import com.fooddelivery.model.Product;
import com.fooddelivery.model.Restaurant;
import com.fooddelivery.service.RestaurantService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class Helper {

    public static Driver getRandomDriver() {
        ArrayList<Driver> drivers = new ArrayList<>();

        drivers.add(new Driver("Alin Popa", "0742152993", "alin.popa@foody.com", 4.7));
        drivers.add(new Driver("Razvan Ionescu", "0522114993", "razvan.ionescu@foody.com", 4.98));
        drivers.add(new Driver("Andreea Radulescu", "1234567890", "andreea.radulescu@foody.com", 5.0));
        drivers.add(new Driver("Ioana Novac", "9876543219", "ioana.novac@foody.com", 4.87));
        drivers.add(new Driver("Izabela Xulescu", "0789332635", "izabela.xulescu@foody.com", 4.85));
        drivers.add(new Driver("Andrei Bejan", "0765988322", "andrei.bejan@foody.com", 4.77));
        drivers.add(new Driver("Adrian Dumitrescu", "0742912953", "adrian.dumitrescu@foody.com", 4.65));
        drivers.add(new Driver("Dragos Gurea", "0742591326", "dragos.gurea@foody.com", 4.93));
        drivers.add(new Driver("Alexandra Turcu", "0783425109", "alexandra.turcu@foody.com", 4.96));
        drivers.add(new Driver("Mario Dan", "0742144329", "mario.dan@foody.com", 4.45));

        return drivers.get(ThreadLocalRandom.current().nextInt(0, drivers.size()));
    }

    public static ArrayList<Restaurant> loadRestaurants() {
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        ArrayList<Product> menu;

        menu = new ArrayList<>();
        menu.add(new Product("McChicken", "Burger cu pui", 12.0));
        menu.add(new Product("Cheeseburger", "Burger de vita cu cascaval", 10.5));
        menu.add(new Product("Big Mac", "Big Mac Carne vită", 11.0));
        menu.add(new Product("Cartofi prajiti", "Cartofi preparaţi în ulei, asezonați cu sare înainte de a fi serviţi", 7.5));
        menu.add(new Product("Coca Cola", "Coca Cola 0.5l", 6.0));
        menu.add(new Product("Fanta", "Fanta 0.5l", 6.0));
        menu.add(new Product("Apa", "Apa plata 0.5l", 5.0));

        Restaurant aux = new Restaurant("McDonald's", new Address("Bulevardul General Gheorghe Magheru 24A"), menu);
        restaurants.add(aux);
        RestaurantService.addRestaurant(aux);

        menu = new ArrayList<>();
        menu.add(new Product("Margherita", "Sos de roșii și brânză Mozzarella", 31.5));
        menu.add(new Product("Europeana", "Sos de roșii, brânză Mozzarella, șuncă, cubulețe cu carne de vită, ciuperci", 39.5));
        menu.add(new Product("California", "Sos de roșii, brânză Mozzarella, piept de pui, porumb, ardei", 39.5));
        menu.add(new Product("Suprema", "Sos de roșii, brânză Mozzarella, salam Pepperoni, cubulețe cu carne de vită, ceapă, ciuperci, ardei", 44.5));
        menu.add(new Product("Nevada", "Sos de roșii, brânză Mozzarella, bacon, șuncă, ciuperci, ardei, măsline", 44.5));
        menu.add(new Product("Quattro stagioni", "Sos de roșii, brânză Mozzarella, șuncă, salam Pepperoni, ciuperci, ardei", 44.5));
        menu.add(new Product("Super Suprema", "Sos de roșii, brânză Mozzarella, salam Pepperoni, cubulețe cu carne de vită, cubulețe cu carne de porc, șuncă, ceapă, ciuperci, ardei, măsline", 49.0));
        menu.add(new Product("Limonada clasica", "Suc de lămâie, sirop de zahăr sau miere, apă", 17.0));
        menu.add(new Product("Coca-Cola Regular", "La pahar 300 ml", 7.0));
        menu.add(new Product("Apa minerala/plata", "330 ml", 7.5));

        aux = new Restaurant("Pizza Hut", new Address("Calea Dorobanti nr. 5-7"), menu);
        restaurants.add(aux);
        RestaurantService.addRestaurant(aux);

        return restaurants;
    }

}

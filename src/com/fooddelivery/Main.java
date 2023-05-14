package com.fooddelivery;

import com.fooddelivery.helper.Helper;
import com.fooddelivery.model.Address;
import com.fooddelivery.model.Client;
import com.fooddelivery.model.Product;
import com.fooddelivery.model.Restaurant;
import com.fooddelivery.service.OrderService;
import com.fooddelivery.service.RestaurantService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        boolean exit = false;

        OrderService orderService = new OrderService();
        ArrayList<Restaurant> restaurants = Helper.loadRestaurants();
        Scanner scanner = new Scanner(System.in);

        while (!exit) {
            // start menu

            listOptions();
            int optiune = scanner.nextInt();

            switch (optiune) {
                case 1:
                    System.out.println("Salut! Te rog, introdu urmatoarele date:");

                    System.out.print("Numele: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();

                    System.out.print("Numarul de telefon: ");
                    String phoneNumber = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Adresa: ");
                    String address = scanner.nextLine();
                    Address clientAddress = new Address(address);

                    Client client = new Client(name, phoneNumber, email, clientAddress);

                    System.out.println("Din ce restaurant ai dori sa comanzi? Introdu cifra: ");
                    RestaurantService.listRestaurants();
                    int rest = scanner.nextInt();
                    Restaurant restaurant = RestaurantService.getRestaurants().get(rest-1);
                    HashMap<Product, Integer> basket = new HashMap<>();

                    System.out.println("Ce produse doresti sa achizitionezi?");
                    System.out.println("0. Inchide meniu si finalizeaza comanda.");
                    System.out.println(restaurant.printMenu());
                    boolean deschis = true;
                    while (deschis) {
                        System.out.println("Selecteaza un produs sau '0' pentru a inchide meniul: ");
                        int numar = scanner.nextInt();
                        if (numar == 0)
                            deschis = false;
                        else {
                            Product produs = restaurant.getMenu().get(numar-1);
                            System.out.println("Cantitate?");
                            int cantitate = scanner.nextInt();

                            basket.put(produs, cantitate);
                        }
                    }

                    orderService.createOrder(client, basket, restaurant);

                    break;
                case 2:
                    RestaurantService.listRestaurants();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    break;
            }
        }
    }

    private static void listOptions() {
        System.out.println("Selecteaza o cifra pentru actiunea pe care o doresti sa o efectuezi:");
        System.out.println("1. Comanda noua");
        System.out.println("2. Listeaza restaurante");
        System.out.println("3. Inchide aplicatia");
    }
}

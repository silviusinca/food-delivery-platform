package com.fooddelivery;

import com.fooddelivery.model.*;
//import com.fooddelivery.service.OrderService;
//import com.fooddelivery.service.RestaurantService;
import com.fooddelivery.service.Service;

import java.sql.Array;
import java.sql.SQLException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, SQLException {

        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        Service service = Service.getInstance();

        while (!exit) {
            listOptions();

            int optiune = scanner.nextInt();

            switch (optiune) {
                case 1:
                    System.out.println("Nume: ");
                    scanner.nextLine();
                    String numeClient = scanner.nextLine();

                    System.out.println("Oras: ");
                    String orasClient = scanner.nextLine();

                    System.out.println("Adresa: ");
                    String adresaClient = scanner.nextLine();

                    System.out.println("Numar de telefon: ");
                    String telefonClient = scanner.nextLine();

                    System.out.println("Adresa email: ");
                    String emailClient = scanner.nextLine();

                    Address newAddress = new Address(orasClient, adresaClient);

                    service.addClient(new Client(numeClient, telefonClient, emailClient, newAddress));
                    break;
                case 2:
                    service.listClients();
                    break;
                case 3:
                    System.out.println("Nume: ");
                    scanner.nextLine();
                    String numeDriver = scanner.nextLine();

                    System.out.println("Numar de telefon: ");
                    String telefonDriver = scanner.nextLine();

                    System.out.println("Adresa email: ");
                    String emailDriver = scanner.nextLine();

                    service.addDriver(new Driver(numeDriver, telefonDriver, emailDriver, 0d));
                    break;
                case 4:
                    service.listDrivers();
                    break;
                case 5:
                    System.out.println("Nume produs: ");
                    scanner.nextLine();
                    String productName = scanner.nextLine();

                    System.out.println("Descriere produs: ");
                    String productDescription = scanner.nextLine();

                    System.out.println("Cost: ");
                    Double productCost = scanner.nextDouble();

                    service.addProduct(new Product(productName, productDescription, productCost));
                    break;
                case 6:
                    service.listProducts();
                    break;
                case 7:
                    Restaurant restaurant = new Restaurant();
                    System.out.println("Nume restaurant: ");
                    scanner.nextLine();
                    ArrayList<Product> menu = new ArrayList<>();
                    String restaurantName = scanner.nextLine();
                    restaurant.setRestaurantName(restaurantName);

                    restaurant.setRestaurantId(UUID.randomUUID());

                    System.out.println("Cate produse doresti sa adaugi?");
                    int numar = scanner.nextInt();
                    for (int i = 1; i <= numar; i++) {
                        System.out.println("Nume produs: ");
                        scanner.nextLine();
                        String _productName = scanner.nextLine();

                        System.out.println("Descriere produs: ");
                        String _productDescription = scanner.nextLine();

                        System.out.println("Cost: ");
                        Double _productCost = scanner.nextDouble();
                        Product _produs = new Product(_productName, _productDescription, _productCost);

                        menu.add(_produs);
                        service.addProduct(_produs);
                        service.associateProductWithRestaurant(_produs.getProductId(), restaurant.getRestaurantId());
                    }

                    restaurant.setMenu(menu);

                    service.addRestaurant(restaurant);
                    break;
                case 8:
                    service.listRestaurants();
                    break;
                case 9:

                    System.out.println("Introdu numele restaurantului pe care vrei sa il stergi");
                    scanner.nextLine();
                    String _restaurantName = scanner.nextLine();
                    for (Restaurant rest : service.getRestaurants()) {
                        if (Objects.equals(rest.getRestaurantName(), _restaurantName)) {
                            service.deleteRestaurant(rest.getRestaurantId());
                        }

                    }
                    break;
                case 10:
                    exit = true;
                    break;
                default:
                    break;
            }
        }
    }

    private static void listOptions() {
        System.out.println("Selecteaza o cifra pentru actiunea pe care o doresti sa o efectuezi:");
        System.out.println("1. Adaugare client");
        System.out.println("2. Listare clienti");
        System.out.println("3. Adaugare driver");
        System.out.println("4. Listare driveri");
        System.out.println("5. Adaugare produs");
        System.out.println("6. Listare produse");
        System.out.println("7. Adaugare restaurant");
        System.out.println("8. Listare restaurante");
        System.out.println("9. Stergere restaurant");
        System.out.println("10. Inchide aplicatia");
    }
//
//    private static void citireProdus(Scanner scanner, Service service) {
//
//    }
}

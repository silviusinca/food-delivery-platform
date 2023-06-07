package com.fooddelivery.service;

import com.fooddelivery.model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Service {
    private static Service instance = null;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/foody";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private List<Client> clients = new ArrayList<>();
    private List<Address> addresses = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private List<Driver> drivers = new ArrayList<>();
    private List<Restaurant> restaurants = new ArrayList<>();
    private List<Product> products = new ArrayList<>();
    Connection con;
    Statement statement;

    private Service() {
        try {
            con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            statement = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            System.out.println(ex.getMessage());
        }
    }

    public static synchronized Service getInstance() {
        if (instance == null)
            instance = new Service();

        return instance;
    }

    public void addClient(Client client) {
        clients.add(client);

        String sql = "INSERT INTO CLIENT VALUES('" + client.getClientId()  + "', '" + client.getName() + "', '"
                + client.getAddress().getCity() + "', '"
                + client.getAddress().getStreet() + "', '"
                + client.getPhoneNumber() + "', '"
                + client.getEmail() + "')";

        try {
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("hopa adaugare client");
        }

        System.out.println("Client adaugat!");
    }
    public void listClients() {
        String sql = "SELECT clientName, phoneNumber FROM CLIENT";

        try {
            var result = statement.executeQuery(sql);

            while (result.next()) {
                System.out.println(result.getString(1) + ", cu numarul de telefon: " + result.getString(2));
            }
        } catch (SQLException ex) {
            System.out.println("hopa list client");
            System.out.println(ex.getMessage());
        }
    }

    public void addDriver(Driver driver) {
        drivers.add(driver);

        String sql = "INSERT INTO DRIVER VALUES('" + driver.getDriverId()  + "', '" + driver.getName() + "', '"
                + driver.getPhoneNumber() + "', '"
                + driver.getEmail() + "')";

        try {
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("hopa adaugare driver");
        }

        System.out.println("Driver adaugat!");
    }

    public void listDrivers() {
        String sql = "SELECT driverName, phoneNumber FROM DRIVER";

        try {
            var result = statement.executeQuery(sql);

            while (result.next()) {
                System.out.println(result.getString(1) + ", cu numarul de telefon: " + result.getString(2));
            }
        } catch (SQLException ex) {
            System.out.println("hopa list driveri");
            System.out.println(ex.getMessage());
        }
    }

    public void addProduct(Product product) {
        products.add(product);

        String sql = "INSERT INTO PRODUCT VALUES('" + product.getProductId()  + "', '" + product.getName() + "', '"
                + product.getDescription() + "', '"
                + product.getCost() + "')";

        try {
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("hopa adaugare produs");
        }

        System.out.println("Produs adaugat!");
    }

    public void listProducts() {
        String sql = "SELECT productName, productCost FROM PRODUCT";

        try {
            var result = statement.executeQuery(sql);

            while (result.next()) {
                System.out.println(result.getString(1) + ", care costa: " + result.getString(2));
            }
        } catch (SQLException ex) {
            System.out.println("hopa list products");
            System.out.println(ex.getMessage());
        }
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);

        String sql = "INSERT INTO RESTAURANT VALUES('" + restaurant.getRestaurantId()  + "', '" + restaurant.getRestaurantName() + "', '"
                + restaurant.getAddress().getCity() + "', '"
                + restaurant.getAddress().getStreet() + "')";

        try {
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("hopa adaugare restaurant");
        }

        System.out.println("Restaurant adaugat!");
    }

    public void listRestaurants() {
        String sql = "SELECT restaurantId, city, address FROM RESTAURANT";

        try {
            var result = statement.executeQuery(sql);

            while (result.next()) {

                System.out.println(result.getString(1) + ", care se afla la adresa: " + result.getString(2) + ", " + result.getString(3));
            }
        } catch (SQLException ex) {
            System.out.println("hopa list restaurants");
            System.out.println(ex.getMessage());
        }

    }

    public void associateProductWithRestaurant(UUID productId, UUID restaurantId) throws SQLException {
        String sql = "INSERT INTO RESTAURANT_PRODUCTS (productId, restaurantId) VALUES ('" + productId + "', '" + restaurantId + "')";

        try {
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("hopa asociere produs restaurant");
        }
    }

    public List<Product> getProductsForRestaurant(UUID restaurantId) throws SQLException {
        List<Product> menu = new ArrayList<>();
        String sql = "SELECT p.productId, p.productName, p.productDescription, p.productCost FROM PRODUCTS p " +
                "INNER JOIN RESTAURANT_PRODUCTS rp ON p.productId = rp.productId " +
                "WHERE rp.restaurantId = '" + restaurantId + "'";

        try  {
            var result = statement.executeQuery(sql);

            while (result.next()) {
                Product product = new Product();
                product.setProductId(UUID.fromString(result.getString("productId")));
                product.setName(result.getString("productName"));
                product.setDescription(result.getString("productDescription"));
                product.setCost(result.getDouble("productCost"));
                menu.add(product);
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("hopa get product for restaurant");
        }

        return menu;
    }

    public List<Restaurant> getRestaurants() {
        List<Restaurant> restaurantList = new ArrayList<>();

        String sql = "SELECT restaurantId, restaurantName, city, address FROM RESTAURANT";

        try {
            var result = statement.executeQuery(sql);

            while (result.next()) {
                Restaurant rest = new Restaurant();
                rest.setRestaurantId(UUID.fromString(result.getString("restaurantId")));
                rest.setRestaurantName(result.getString("restaurantName"));
                rest.setAddress(new Address(result.getString("city"), result.getString("addresses")));
                restaurantList.add(rest);
//                System.out.println(result.getString(1) + ", care se afla la adresa: " + result.getString(2) + ", " + result.getString(3));
            }
        } catch (SQLException ex) {
            System.out.println("hopa list restaurants");
            System.out.println(ex.getMessage());
        }


        return restaurantList;
    }

    public void deleteRestaurant(UUID restaurantId) {
        for (Restaurant rest : restaurants) {
            if (rest.getRestaurantId() == restaurantId) {
                restaurants.remove(rest);
                break;
            }
        }
        String qrySQL = "DELETE FROM RESTAURANTS WHERE restaurantId = '"
                + restaurantId + "'";

        try {
            statement.executeUpdate(qrySQL);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


    }

}

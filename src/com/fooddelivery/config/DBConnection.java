package com.fooddelivery.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/foody";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static Connection dbConnection;

    private DBConnection() {
    }

    public static Connection getDBConnection() {
        try {
            if (dbConnection == null || dbConnection.isClosed()) {
                dbConnection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dbConnection;
    }

//    public static void closeDatabaseConnection() {
//        try {
//            if (databaseConnection != null && !databaseConnection.isClosed()) {
//                databaseConnection.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}

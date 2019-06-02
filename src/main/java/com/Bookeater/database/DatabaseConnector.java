package com.Bookeater.database;

import java.sql.*;

public class DatabaseConnector {

    public static Connection getDBConnection () {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Fail to import JDBC driver: " + e.getMessage());
        }
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/Products", "root", "UuINyEpOccooeTn1");
        } catch (SQLException e) {
            throw new RuntimeException("Fail to connect to database: " + e.getMessage());
        }
    }

    public static ResultSet retrieveQueryResults (Connection conn, String sql) {
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}

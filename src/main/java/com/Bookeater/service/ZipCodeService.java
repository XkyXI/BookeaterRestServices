package com.Bookeater.service;

import com.Bookeater.database.DatabaseConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ZipCodeService {
    public static String getCityState(String zip) {
        String sql = "SELECT * FROM `ZipCode` WHERE `zip` = " + zip;
        Connection conn = DatabaseConnector.getDBConnection();
        ResultSet rs = DatabaseConnector.retrieveQueryResults(conn, sql);
        String result = "";
        try {
            if (rs.next()) {
                result += rs.getString("city") + "," + rs.getString("state");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}

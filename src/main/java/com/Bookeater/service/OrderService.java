package com.Bookeater.service;

import com.Bookeater.database.DatabaseConnector;
import com.Bookeater.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderService {

    public static Order getOrder() {
        String sql = "SELECT * FROM OrderSummary ORDER BY order_num DESC LIMIT 1";
        Connection conn = DatabaseConnector.getDBConnection();
        ResultSet rs = DatabaseConnector.retrieveQueryResults(conn, sql);
        if (rs != null) {
            try {
                if (rs.next()) {
                    Order order = new Order();
                    ServiceUtils.fillOrderInfo(rs, order);
                    return order;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static int postOrder(Order order) {
        String sql = "INSERT INTO OrderSummary (books, firstname, lastname, phone," +
                "address, ship_method, ccard_name, ccard_num, ccard_date," +
                "ccard_code, ccard_zip) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = DatabaseConnector.getDBConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, order.getBooks());
            stmt.setString(2, order.getFirstName());
            stmt.setString(3, order.getLastName());
            stmt.setString(4, order.getPhone());
            stmt.setString(5, order.getAddress());
            stmt.setString(6, order.getShipMethod());
            stmt.setString(7, order.getCcardName());
            stmt.setString(8, order.getCcardNumber());
            stmt.setString(9, order.getCcardDate());
            stmt.setInt(10, order.getCcardCode());
            stmt.setString(11, order.getCcardZip());

            return DatabaseConnector.insertData(stmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}

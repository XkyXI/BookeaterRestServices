package com.Bookeater.service;

import com.Bookeater.database.DatabaseConnector;
import com.Bookeater.model.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryService {

    public static List<Category> getAllCategories () {
        String sql = "SELECT * FROM Categories";
        Connection conn = DatabaseConnector.getDBConnection();
        ResultSet rs = DatabaseConnector.retrieveQueryResults(conn, sql);

        List<Category> categories = new ArrayList<>();
        if (rs != null) {
            try {
                while (rs.next()) {
                    Category cat = new Category();
                    cat.setCid(rs.getString("cid"));
                    cat.setCname(rs.getString("category"));
                    categories.add(cat);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return categories;
    }

    public static Category getCategoryByCategoryId (String cid) {
        String sql = "SELECT * FROM Categories WHERE cid = \"" + cid + "\"";
        Connection conn = DatabaseConnector.getDBConnection();
        ResultSet rs = DatabaseConnector.retrieveQueryResults(conn, sql);

        if (rs != null) {
            try {
                if (rs.next()) {
                    Category cat = new Category();
                    cat.setCid(rs.getString("cid"));
                    cat.setCname(rs.getString("category"));
                    return cat;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}

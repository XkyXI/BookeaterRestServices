package com.Bookeater.service;

import com.Bookeater.database.DatabaseConnector;
import com.Bookeater.model.Book;
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
                throw new RuntimeException(e.getMessage());
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
        }
        return categories;
    }


    public static List<Book> getBooksByCategoryId (String cid) {
        String sql = "SELECT * FROM Books WHERE category = \"" + cid + "\"";
        Connection conn = DatabaseConnector.getDBConnection();
        ResultSet rs = DatabaseConnector.retrieveQueryResults(conn, sql);

        List<Book> books = new ArrayList<>();
        if (rs != null) {
            try {
                while (rs.next()) {
                    Book b = new Book();
                    ServiceUtils.fillBookInfo(rs, b);
                    books.add(b);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
        }
        return books;
    }
}

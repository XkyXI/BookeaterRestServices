package com.Bookeater.service;

import com.Bookeater.database.DatabaseConnector;
import com.Bookeater.model.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookService {

    public static List<Book> getAllBooks() {
        String sql = "SELECT * FROM Books";
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
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return books;
    }

    public static Book getBookById(String id) {
        String sql = "SELECT * FROM Books WHERE ISBN = \"" + id + "\"";
        Connection conn = DatabaseConnector.getDBConnection();
        ResultSet rs = DatabaseConnector.retrieveQueryResults(conn, sql);
        if (rs != null) {
            try {
                if (rs.next()) {
                    Book prod = new Book();
                    ServiceUtils.fillBookInfo(rs, prod);
                    return prod;
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

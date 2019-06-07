package com.Bookeater.service;

import com.Bookeater.database.DatabaseConnector;
import com.Bookeater.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookService {

    public static List<Book> queryListOfBooks (String sql) {
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

    public static List<Book> getAllBooks() {
        String sql = "SELECT * FROM Books";
        return queryListOfBooks(sql);
    }

    public static List<Book> getBooksByCategoryId (String cid) {
        String sql = "SELECT * FROM Books WHERE category = \"" + cid + "\"";
        return queryListOfBooks(sql);
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

    public static List<Book> getBooksByKeyword(String key) {
        String sql = "SELECT DISTINCT `Books`.* FROM `Books`, `Categories` WHERE (" +
                "UPPER(`Books`.`title`) LIKE UPPER(?) or UPPER(`Books`.`author`) LIKE UPPER(?) or" +
                "(`Books`.`ISBN` = ?) or `Categories`.`cid` = `Books`.`category` AND " +
                "UPPER(`Categories`.`category`) LIKE UPPER(?))";
        List<Book> bookList = new ArrayList<>();
        try {
            Connection conn = DatabaseConnector.getDBConnection();
            PreparedStatement stmt = prepareStatement(conn, sql, key);
            ResultSet rs = DatabaseConnector.retrievePreparedStatementResults(stmt);
            while (rs.next()) {
                Book b = new Book();
                ServiceUtils.fillBookInfo(rs, b);
                bookList.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public static String getSuggestionByKeyword(String key) {
        String sql = "SELECT DISTINCT `title` AS suggest FROM `Books` WHERE UPPER(`title`) LIKE UPPER(?) " +
                "UNION " +
                "SELECT DISTINCT `author` AS suggest FROM `Books` WHERE UPPER(`author`) LIKE UPPER(?) " +
                "UNION " +
                "SELECT DISTINCT `ISBN` AS suggest FROM `Books` WHERE `ISBN` = ? " +
                "UNION " +
                "SELECT DISTINCT `category` AS suggest FROM `Categories` WHERE UPPER(`category`) LIKE UPPER(?) " +
                "LIMIT 10";
        String result = "";
        try {
            Connection conn = DatabaseConnector.getDBConnection();
            PreparedStatement stmt = prepareStatement(conn, sql, key);
            ResultSet rs = DatabaseConnector.retrievePreparedStatementResults(stmt);
            while (rs.next()) {
                result += rs.getString("suggest") + "\n";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static PreparedStatement prepareStatement (Connection conn, String sql, String key) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(sql);
        String query_like = "%" + key + "%";
        stmt.setString(1, query_like);
        stmt.setString(2, query_like);
        stmt.setString(3, key);
        stmt.setString(4, query_like);
        return stmt;
    }
}

package com.Bookeater.service;

import com.Bookeater.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceUtils {
    public static void fillBookInfo (ResultSet rs, Book bk) throws SQLException {
        bk.setISBN(rs.getString("ISBN"));
        bk.setTitle(rs.getString("title"));
        bk.setAuthor(rs.getString("author"));
        bk.setEdition(rs.getString("edition"));
        bk.setPrice(rs.getInt("price"));
        bk.setYear(rs.getInt("year"));
        bk.setPublisher(rs.getString("publisher"));
        bk.setImage(rs.getString("img"));
    }
}

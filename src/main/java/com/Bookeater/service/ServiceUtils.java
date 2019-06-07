package com.Bookeater.service;

import com.Bookeater.model.Book;
import com.Bookeater.model.Order;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceUtils {
    public static void fillBookInfo (ResultSet rs, Book bk) throws SQLException {
        bk.setBookId(rs.getString("ISBN"));
        bk.setTitle(rs.getString("title"));
        bk.setAuthor(rs.getString("author"));
        bk.setEdition(rs.getString("edition"));
        bk.setPrice(rs.getInt("price"));
        bk.setYear(rs.getInt("year"));
        bk.setPublisher(rs.getString("publisher"));
        bk.setImage(rs.getString("img"));
    }

    public static void fillOrderInfo(ResultSet rs, Order order) throws SQLException {
        order.setBooks(rs.getString("books"));
        order.setFirstName(rs.getString("firstname"));
        order.setLastName(rs.getString("lastname"));
        order.setPhone(rs.getString("phone"));
        order.setAddress(rs.getString("address"));
        order.setShipMethod(rs.getString("ship_method"));
        order.setCcardName(rs.getString("ccard_name"));
        order.setCcardNumber(rs.getString("ccard_num"));
        order.setCcardDate(rs.getString("ccard_date"));
        order.setCcardCode(rs.getInt("ccard_code"));
        order.setCcardZip(rs.getString("ccard_zip"));
    }
}

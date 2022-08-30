package com.thanhnh.service;

import com.thanhnh.config.JDBCConnection;
import com.thanhnh.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class OrdersService {
    /*
    Get one order by id
     */
    public Order get(String id) {
        Order order = new Order();
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = JDBCConnection.getConnection();
            pst = con.prepareStatement("SELECT * FROM user.`order` WHERE id = '" + id + "'");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                order.setId(rs.getString("id"));
                order.setClientName(rs.getString("client_name"));
                order.setAmount(rs.getInt("amount"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }

    /*
    Get all order
     */
    public List<Order> getAll() {
        List<Order> orderList = new ArrayList<Order>();
        Connection con = null;
        try {
            con = JDBCConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user.`order`");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getString("id"));
                order.setClientName(rs.getString("client_name"));
                order.setAmount(rs.getInt("amount"));
                orderList.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderList;
    }

    /*
    Save one order into db
     */
    public void save(Order order) {
        Connection con = null;
        try {
            con = JDBCConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO user.`order`(client_name, amount) VALUES ('" + order.getClientName() + "'," + order.getAmount() + ")");

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    Update one order
     */
    public void update(String id, Order order) {
        Connection con = null;
        try {
            con = JDBCConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE user.`order` SET client_name='" + order.getClientName() + "', amount=" + order.getAmount() + " WHERE id = " + id);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    Delete one order
     */
    public void remove(String id) {
        Connection con = null;
        try {
            con = JDBCConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM user.`order` WHERE id=" + id);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

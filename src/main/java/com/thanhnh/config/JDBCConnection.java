package com.thanhnh.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    public static String url = "jdbc:mysql://localhost:3306/user?useUnicode=yes&characterEncoding=UTF-8";
    private static String driverName = "com.mysql.cj.jdbc.Driver";
    public static String username = "root";
    public static String password = "21102000";
    private static Connection con;

    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                System.out.println("Failed to create the database connection.");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found.");
        }
        return con;
    }
}

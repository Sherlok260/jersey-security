package com.example.jersey_todo.db_connection_provider;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
    public static Connection getConnection() {
        Connection con = null;
        String user_name = "postgres";
        String password = "root___";
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", user_name, password);
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
}

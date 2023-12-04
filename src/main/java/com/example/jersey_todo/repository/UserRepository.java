package com.example.jersey_todo.repository;

import com.example.jersey_todo.db_connection_provider.ConnectionProvider;
import com.example.jersey_todo.payload.ApiResponse;
import com.example.jersey_todo.payload.BookDto;
import com.example.jersey_todo.payload.RegisterDto;
import com.example.jersey_todo.tables.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class UserRepository {

    Connection con = ConnectionProvider.getConnection();

    public void createUser(RegisterDto dto) {
        String sql = "insert into users(first_name, username, password, role)" +
                "values('" + dto.getFirstName() + "', '" + dto.getUsername() + "', '" +
                dto.getPassword() + "', 'USER');";
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ApiResponse getUserByUsername(String username) {
        try {
            String sql = "select * from users where username='"+username+"';";
            User user = new User();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                user.setFirstName(rs.getString("first_name"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRoles(new String[]{rs.getString("role")});
            }
            return new ApiResponse("user", true, user);
        } catch (SQLException e) {
            e.printStackTrace();
            return new ApiResponse("some error", false);
        }
    }
}

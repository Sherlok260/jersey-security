package com.example.jersey_todo.repository;

import com.example.jersey_todo.db_connection_provider.ConnectionProvider;
import com.example.jersey_todo.payload.ApiResponse;
import com.example.jersey_todo.payload.BookDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookRepository {
    Connection con = ConnectionProvider.getConnection();
    
    public ApiResponse add(BookDto dto) throws SQLException {
        String sql = "insert into books(name, category, price, author, year, created)" +
                "values('" + dto.getName() + "', '" + dto.getCategory() + "', " +
                dto.getPrice() + ", '" + dto.getAuthor() + "', " + dto.getYear() + ", '" +
                new Date() + "');";
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
            return new ApiResponse("success", true, getLastBook().getObj());
        } catch (Exception e) {
            System.out.println(e);
            return new ApiResponse(e.getMessage(), false);
        }
    }

    public ApiResponse editBook(BookDto dto) throws SQLException {
        String sql = "update books set " +
                "name='" + dto.getName() + "', category='" + dto.getCategory() + "', price='" +
                dto.getPrice() + "', author='" + dto.getAuthor() + "', year='" + dto.getYear() + "', created='" +
                new Date() + "' where id=" + dto.getId() + ";";
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
            return new ApiResponse("success", true);
        } catch (Exception e) {
            System.out.println(e);
            return new ApiResponse(e.getMessage(), false);
        }
    }

    public ApiResponse deleteBook(int id) throws SQLException {
        String sql = "delete from books where id=" + id + ";";
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
            return new ApiResponse("success", true);
        } catch (Exception e) {
            System.out.println(e);
            return new ApiResponse(e.getMessage(), false);
        }
    }

    public ApiResponse getBooks() throws SQLException {
        List<BookDto> books = new ArrayList<>();
        String sql = "select * from books;";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                BookDto b = new BookDto();
                b.setId(rs.getInt("id"));
                b.setName(rs.getString("name"));
                b.setCategory(rs.getString("category"));
                b.setPrice(rs.getInt("price"));
                b.setAuthor(rs.getString("author"));
                b.setYear(rs.getInt("year"));
                books.add(b);
            }
            return new ApiResponse("success", true, books);
        } catch (Exception e) {
            System.out.println(e);
            return new ApiResponse(e.getMessage(), false);
        }
    }

    public ApiResponse searcher(String s_text) throws SQLException {
        String sql = "select * from books where name ilike '%" + s_text + "%';";
        List<BookDto> books = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                BookDto b = new BookDto();

                b.setId(rs.getInt("id"));
                b.setName(rs.getString("name"));
                b.setCategory(rs.getString("category"));
                b.setPrice(rs.getInt("price"));
                b.setAuthor(rs.getString("author"));
                b.setYear(rs.getInt("year"));

                books.add(b);
            }
            return new ApiResponse("success", true, books);
        } catch (Exception e) {
            System.out.println(e);
            return new ApiResponse(e.getMessage(), false);
        }
    }

    public ApiResponse sort(String sort_arg) throws SQLException {
        String sql = "select* from books order by " + sort_arg + ";";
        List<BookDto> books = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                BookDto b = new BookDto();
                b.setId(rs.getInt("id"));
                b.setName(rs.getString("name"));
                b.setCategory(rs.getString("category"));
                b.setPrice(rs.getInt("price"));
                b.setAuthor(rs.getString("author"));
                b.setYear(rs.getInt("year"));
                books.add(b);
            }
            return new ApiResponse("success", true, books);
        } catch (Exception e) {
            System.out.println(e);
            return new ApiResponse(e.getMessage(), false);
        }
    }

    public ApiResponse getLastBook() throws SQLException {
        try {
            String sql = " select * from books where id=(select max(id) from books)";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            BookDto b = new BookDto();
            if (rs.next()) {
                b.setId(rs.getInt("id"));
                b.setName(rs.getString("name"));
                b.setCategory(rs.getString("category"));
                b.setPrice(rs.getInt("price"));
                b.setAuthor(rs.getString("author"));
                b.setYear(rs.getInt("year"));
            }
            return new ApiResponse("last book", true, b);
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse("some error", false);
        }
    }
}

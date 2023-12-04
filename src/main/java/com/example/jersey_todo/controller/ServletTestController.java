package com.example.jersey_todo.controller;

import com.example.jersey_todo.jwt.JwtProvider;
import com.example.jersey_todo.payload.ApiResponse;
import com.example.jersey_todo.payload.BookDto;
import com.example.jersey_todo.utills.Utills;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "jwtServlet", value = "/servlet-test")
public class ServletTestController extends HttpServlet {

    JwtProvider jwtProvider = new JwtProvider();

    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String param = "salom";
        try {
            param = request.getParameter("book");
        } catch (Exception e) {
            System.out.println("xatolik");
        }
        System.out.println(param);
        response.setContentType("application/json");
        ApiResponse apiResponse = new ApiResponse("success", true, param);
        PrintWriter out = response.getWriter();
        out.println(apiResponse);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            BookDto bookDto = Utills.readValue(request, BookDto.class);
            System.out.println(bookDto);
            response.setContentType("application/json");
            ApiResponse apiResponse = new ApiResponse("success", true, bookDto);
            PrintWriter out = response.getWriter();
            out.println(apiResponse);
        } catch (Exception e) {
            System.out.println("xatolik");
        }
    }

    public void destroy() {
    }
}

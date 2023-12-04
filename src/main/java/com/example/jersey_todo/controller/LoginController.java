package com.example.jersey_todo.controller;

import com.example.jersey_todo.jwt.JwtProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        String username = "exampleUser";
//        String token = JwtProvider.generateToken(username);
        response.getWriter().write("welcome");
    }
}

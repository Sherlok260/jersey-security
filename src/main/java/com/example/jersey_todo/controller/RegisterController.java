package com.example.jersey_todo.controller;

import com.example.jersey_todo.jwt.JwtProvider;
import com.example.jersey_todo.payload.RegisterDto;
import com.example.jersey_todo.repository.UserRepository;
import com.example.jersey_todo.tables.Role;
import com.example.jersey_todo.tables.User;
import com.example.jersey_todo.utills.Utills;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet("/register")
@PermitAll
public class RegisterController extends HttpServlet {

    UserRepository userRepository = new UserRepository();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RegisterDto registerDto = Utills.readValue(request, RegisterDto.class);
        userRepository.createUser(registerDto);
        String token = JwtProvider.generateToken(registerDto.getUsername());
        response.getWriter().write(token);
    }
}

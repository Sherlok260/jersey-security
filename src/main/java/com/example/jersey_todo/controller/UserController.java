package com.example.jersey_todo.controller;

import com.example.jersey_todo.payload.ApiResponse;
import com.example.jersey_todo.tables.User;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Singleton;
import javax.security.enterprise.SecurityContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import java.io.IOException;

//@WebServlet("/user")
//@RolesAllowed("ADMIN")
//public class UserController extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().write("salom user");
//    }
//}

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Singleton
public class UserController {

    @Context
    SecurityContext securityContext;

    @RolesAllowed("ADMIN")
    @GET
    public ApiResponse getUser() {
//        User user = (User)securityContext.getCallerPrincipal();
        System.err.println(securityContext.getCallerPrincipal().getName());
        return new ApiResponse("success", true);
    }
}
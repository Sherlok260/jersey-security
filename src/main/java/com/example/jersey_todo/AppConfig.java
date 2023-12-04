package com.example.jersey_todo;

import com.example.jersey_todo.controller.UserController;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class AppConfig extends ResourceConfig {
    public AppConfig() {
//        super(UserController.class);
        packages("com.example.jersey_todo.controller");
        register(RolesAllowedDynamicFeature.class);
    }
}
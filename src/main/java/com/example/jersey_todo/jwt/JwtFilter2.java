package com.example.jersey_todo.jwt;

import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestFilter;

import com.example.jersey_todo.payload.ApiResponse;
import com.example.jersey_todo.repository.UserRepository;
import com.example.jersey_todo.tables.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.annotation.Priority;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.security.Principal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class JwtFilter2 implements ContainerRequestFilter {

    UserRepository userRepository = new UserRepository();

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);

            try {
                if (JwtProvider.validateToken(token)) {
                    String username = JwtProvider.getUsername(token); // Assuming the subject contains the username
                    ApiResponse apiResponse = userRepository.getUserByUsername(username);
                    if (apiResponse.isSuccess()) {
                        System.out.println("Roles set in JwtSecurityContext: " + Arrays.toString(((User)apiResponse.getObj()).getRoles()));
                        JwtSecurityContext jwtSecurityContext = new JwtSecurityContext((User) apiResponse.getObj(), requestContext.getSecurityContext().isSecure());
                        requestContext.setSecurityContext(jwtSecurityContext);
                        System.out.println(requestContext.getSecurityContext().isUserInRole("USER"));
                        System.out.println(jwtSecurityContext);
                    } else {
                        requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity("Invalid token").build());
                    }
                } else {
                    requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity("Invalid token").build());
                }
            } catch (Exception e) {
                requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity("Invalid token").build());
            }
        } else {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity("Missing or invalid authorization header").build());
        }
    }


    public static class JwtSecurityContext implements SecurityContext {

        private User principal;
        private boolean isSecure;
        private Set<String> roles = new HashSet<>();

        public JwtSecurityContext(final User principal, final boolean isSecure) {
            this.principal = principal;
            this.isSecure = isSecure;
            String[] names = principal.getRoles();
            for (String n : names) {
                roles.add(n);
            }
        }

        @Override
        public String getAuthenticationScheme() {
            return "JWT"; // informational
        }

        @Override
        public Principal getUserPrincipal() {
            return principal;
        }

        @Override
        public boolean isSecure() {
            return isSecure;
        }

        @Override
        public boolean isUserInRole(final String role) {
            for (String userRole : roles) {
                if (role.equals(userRole)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("JWTSecurityContext {")
                    .append("principal:").append(principal).append(",")
                    .append("roles:").append(roles).append(",")
                    .append("isSecure:").append(isSecure)
                    .append("}");
            return builder.toString();
        }
    }

}
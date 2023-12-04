//package com.example.jersey_todo.jwt;
//
//import com.example.jersey_todo.tables.User;
//
//import javax.ws.rs.core.SecurityContext;
//import java.security.Principal;
//import java.util.HashSet;
//import java.util.Set;
//
//public class JwtSecurityContext implements SecurityContext {
//
//    private User principal;
//    private boolean isSecure;
//    private Set<String> roles = new HashSet<>();
//
//    public JwtSecurityContext(final User principal, final boolean isSecure) {
//        this.principal = principal;
//        this.isSecure = isSecure;
//        String[] names = principal.getRoles();
//        for (String n : names) {
//            roles.add(n);
//        }
//    }
//
//    @Override
//    public String getAuthenticationScheme() {
//        return "JWT"; // informational
//    }
//
//    @Override
//    public Principal getUserPrincipal() {
//        return principal;
//    }
//
//    @Override
//    public boolean isSecure() {
//        return isSecure;
//    }
//
//    @Override
//    public boolean isUserInRole(final String role) {
//        for (String userRole : roles) {
//            if (role.equals(userRole)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//        builder.append("JWTSecurityContext {")
//                .append("principal:").append(principal).append(",")
//                .append("roles:").append(roles).append(",")
//                .append("isSecure:").append(isSecure)
//                .append("}");
//        return builder.toString();
//    }
//}
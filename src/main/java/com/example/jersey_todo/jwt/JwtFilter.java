//package com.example.jersey_todo.jwt;
//
//import javax.security.enterprise.SecurityContext;
//import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
//import javax.security.enterprise.credential.Credential;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.List;
//
////@WebServlet(name = "jwtServlet", value = "/generate-token")
//@WebFilter
//public class JwtFilter implements Filter {
//
//    private List<String> permittedUrls = Arrays.asList("/", "/hello", "/login", "/register");
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//
//        String requestURI = ((HttpServletRequest) request).getRequestURI();
//        if (permittedUrls.contains(requestURI)) {
//            chain.doFilter(request, response);
//            return;
//        }
//
//        String token = ((HttpServletRequest) request).getHeader("Authorization");
//        if (token != null && token.startsWith("Bearer ")) {
//            token = token.substring(7);
//            if (JwtProvider.validateToken(token)) {
//
//                chain.doFilter(request, response);
//            }
//        }
//
////        response.getWriter().write("Unauthorized");
//    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
//}

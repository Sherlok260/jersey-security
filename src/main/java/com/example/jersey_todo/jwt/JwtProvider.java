package com.example.jersey_todo.jwt;

import com.example.jersey_todo.tables.Role;
import com.example.jersey_todo.tables.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class JwtProvider {

    private static String secret = "qwertyuiopasdfgrjklzxcvbnm314159265358979323846264qwertyuiopasdfghjklzxcvbnm314159265358979323846264";
    private static byte[] keyByte = Decoders.BASE64.decode(secret);
    private static Key key = Keys.hmacShaKeyFor(keyByte);
    private static long expTime = 1000 * 3600 * 24;

    public static String generateToken(String username) {
//        List<String> roles = Arrays.stream(user.getRoles())
//                .map(Role::new)
//                .collect(Collectors.toList());

        return Jwts
                .builder()
                .signWith(key, SignatureAlgorithm.HS256)
                .setExpiration(new Date(System.currentTimeMillis() + expTime))
                .setSubject(username)
//                .claim("roles", roles)
                .compact();
    }

    public static List<String> getRolesFromToken(String token) {
        Jws<Claims> claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token);
        return claims.getBody().get("roles", List.class);
    }

    public static boolean validateToken(String token) {
        try {
            Jwts
                    .parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String getUsername(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}

package com.example.jersey_todo.utills;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

public class Utills {
    public static  <T> T readValue(HttpServletRequest request, Class<T> valueType) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        String data = sb.toString();
        return new ObjectMapper().readValue(data, valueType);
    }
}

package com.example.jersey_todo;

import com.example.jersey_todo.payload.ApiResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello-world")
public class HelloResource {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }

    @POST
    @Path("/response")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response test(ApiResponse apiResponse) {
        return Response
                .ok(apiResponse)
                .header("Access-Control-Allow-Origin", "*")
                .status(200)
                .build();
    }

}
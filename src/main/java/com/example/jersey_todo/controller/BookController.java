package com.example.jersey_todo.controller;


import com.example.jersey_todo.payload.ApiResponse;
import com.example.jersey_todo.payload.BookDto;
import com.example.jersey_todo.payload.TestDto;
import com.example.jersey_todo.repository.BookRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("books")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookController {

	BookRepository br = new BookRepository();

	@Path("/hello")
	@GET
	public ApiResponse hello() {
		return new ApiResponse("success", true);
	}

	@Path("/addBook")
	@POST
	public ApiResponse add(BookDto dto) throws SQLException {
		return br.add(dto);
	}

	@PUT
	@Path("/editBook")
	public ApiResponse edit(BookDto dto) throws SQLException {
		return br.editBook(dto);
	}

	@Path("/testPost")
	@POST
	public ApiResponse testPost(TestDto dto) {
		ApiResponse apiResponse = new ApiResponse("success", true, dto);
		if(dto.getAge() == 23) {
			return apiResponse;
		} else {
			apiResponse.setSuccess(false);
		}
		return apiResponse;
	}

	@GET
	@Path("/getAll")
    public Response getAllBooks() throws SQLException {
        return Response
				.ok(br.getBooks().getObj())
				.status(200)
    	      	.build();
    }

	@DELETE
	@Path("/delete/{id}")
	public ApiResponse deleteById(@PathParam("id") int id) throws SQLException {
		return br.deleteBook(id);
	}

	@GET
    @Path("/search/{name}")
	public ApiResponse search(@PathParam("name") String name) throws SQLException {
		return br.searcher(name);
	}

	@GET
	@Path("/sort/{arg}")
	public ApiResponse sort(@PathParam("arg") String sort_arg) throws SQLException {
		return br.sort(sort_arg);
	}

}

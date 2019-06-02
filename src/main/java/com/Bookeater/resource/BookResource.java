package com.Bookeater.resource;

import com.Bookeater.model.Book;
import com.Bookeater.service.BookService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/book")
public class BookResource {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Book> getAllBooks() {
        return BookService.getAllBooks();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Book getBookById(@PathParam("id") String isbn) {
        return BookService.getBookById(isbn);
    }
}

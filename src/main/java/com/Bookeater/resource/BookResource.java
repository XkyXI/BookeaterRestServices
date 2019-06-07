package com.Bookeater.resource;

import com.Bookeater.model.Book;
import com.Bookeater.service.BookService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/books")
public class BookResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAllBooks() {
        return BookService.getAllBooks();
    }

    @Path("/byBookId/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Book getBookById(@PathParam("id") String isbn) {
        return BookService.getBookById(isbn);
    }

    @Path("/byCategory/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getBookByCategory(@PathParam("id") String cid) {
        return BookService.getBooksByCategoryId(cid);
    }

    @Path("/byKeyword/{word}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getBooksByKeyword(@PathParam("word") String key) {
        return BookService.getBooksByKeyword(key);
    }

    @Path("/suggestions/byKeyword/{word}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getSuggestionByKeyword(@PathParam("word") String key) {
        return BookService.getSuggestionByKeyword(key);
    }
}

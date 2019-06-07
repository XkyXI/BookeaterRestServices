package com.Bookeater.resource;

import com.Bookeater.model.Book;
import com.Bookeater.service.BookService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/books")
public class BookResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAllBooks() {
        List<Book> bookList = BookService.getAllBooks();
        if (bookList == null || bookList.isEmpty())
            throw new NotFoundException();
        return bookList;
    }

    @Path("/byBookId/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Book getBookById(@PathParam("id") String isbn) {
        Book b = BookService.getBookById(isbn);
        if (b == null)
            throw new NotFoundException();
        return b;
    }

    @Path("/byCategory/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getBookByCategory(@PathParam("id") String cid) {
        List<Book> bookList = BookService.getBooksByCategoryId(cid);
        if (bookList == null || bookList.isEmpty())
            throw new NotFoundException();
        return bookList;
    }

    @Path("/byKeyword/{word}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getBooksByKeyword(@PathParam("word") String key) {
        List<Book> bookList = BookService.getBooksByKeyword(key);
        if (bookList == null || bookList.isEmpty())
            throw new NotFoundException();
        return bookList;
    }

    @Path("/suggestions/byKeyword/{word}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getSuggestionByKeyword(@PathParam("word") String key) {
        return BookService.getSuggestionByKeyword(key);
    }
}

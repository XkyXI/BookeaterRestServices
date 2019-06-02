package com.Bookeater.resource;

import com.Bookeater.model.Book;
import com.Bookeater.model.Category;
import com.Bookeater.service.CategoryService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/category")
public class CategoryResource {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Category> getAllCategories () {
        return CategoryService.getAllCategories();
    }

    @Path("/{cid}")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Book> getBooksByCategoryId (@PathParam("cid") String cid) {
        return CategoryService.getBooksByCategoryId(cid);
    }
}

package com.Bookeater.resource;

import com.Bookeater.model.Category;
import com.Bookeater.service.CategoryService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/category")
public class CategoryResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> getAllCategories () {
        List<Category> categories = CategoryService.getAllCategories();
        if (categories == null || categories.isEmpty())
            throw new NotFoundException();
        return categories;
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Category getCategoryById (@PathParam("id") String id) {
        Category cat = CategoryService.getCategoryByCategoryId(id);
        if (cat == null)
            throw new NotFoundException();
        return cat;
    }
}

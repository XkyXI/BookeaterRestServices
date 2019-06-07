package com.Bookeater;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getIt() {
        return "GET /api/books/ <br>" +
                "GET /api/books/byBookId/{id} <br>" +
                "GET /api/books/byCategory/{cid} <br>" +
                "GET /api/books/byKeyword/{word} <br>" +
                "GET /api/books/suggestions/byKeyword/{word} <br><br>" +

                "GET /api/category <br>" +
                "GET /api/category/{cid} <br><br>" +

                "GET /api/order <br>" +
                "POST /api/order <br><br>" +

                "GET /api/zip/{zip}";
    }
}

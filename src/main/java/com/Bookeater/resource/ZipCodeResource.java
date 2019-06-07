package com.Bookeater.resource;

import com.Bookeater.service.ZipCodeService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/zip")
public class ZipCodeResource {

    @Path("/{zip}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getCityState(@PathParam("zip") String zip) {
        return ZipCodeService.getCityState(zip);
    }
}

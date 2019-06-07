package com.Bookeater.resource;

import com.Bookeater.model.Order;
import com.Bookeater.service.OrderService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/order")
public class OrderResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Order getMostRecentOrder() {
        return OrderService.getOrder();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addOrder(Order order) {
        OrderService.postOrder(order);
    }
}

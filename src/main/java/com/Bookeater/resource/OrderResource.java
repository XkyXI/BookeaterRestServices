package com.Bookeater.resource;

import com.Bookeater.model.Order;
import com.Bookeater.service.OrderService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/order")
public class OrderResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Order getMostRecentOrder() {
        Order order = OrderService.getOrder();
        if (order == null)
            throw new NotFoundException();
        return order;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addOrder(Order order) {
        if (OrderService.postOrder(order) == -1)
            throw new BadRequestException();
        return Response.ok().build();
    }
}

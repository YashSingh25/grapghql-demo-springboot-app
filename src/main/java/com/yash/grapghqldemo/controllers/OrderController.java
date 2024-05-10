package com.yash.grapghqldemo.controllers;

import com.yash.grapghqldemo.entities.Order;
import com.yash.grapghqldemo.entities.User;
import com.yash.grapghqldemo.services.OrderService;
import com.yash.grapghqldemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;


    // create orders

    @MutationMapping
    public Order createOrder(
            @Argument String orderDetails,
            @Argument String address,
            @Argument int price,
            @Argument int userId
    ){
        Order order = new Order();
        order.setOrderDetails(orderDetails);
        order.setAddress(address);
        order.setPrice(price);
        User user = userService.getUser(userId);
        order.setUser(user);

        return orderService.createOrder(order);
    }

    // get all orders

    @QueryMapping
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    // get a specific order

    @QueryMapping
    public Order getOrder(@Argument int orderId){
        return orderService.getOrder(orderId);
    }

    // delete order

    @MutationMapping
    public boolean deleteOrder(@Argument int orderId){
        return orderService.deleteOrder(orderId);
    }


}

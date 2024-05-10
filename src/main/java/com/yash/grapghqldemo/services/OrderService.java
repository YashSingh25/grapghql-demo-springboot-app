package com.yash.grapghqldemo.services;

import com.yash.grapghqldemo.entities.Order;
import com.yash.grapghqldemo.helper.ExceptionHandler;
import com.yash.grapghqldemo.repositories.OrderRepo;
import com.yash.grapghqldemo.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private OrderRepo orderRepo;

    // create order
    public Order createOrder(Order order){
        return orderRepo.save(order);
    }

    // get all orders
    public List<Order> getAllOrders(){
        return orderRepo.findAll();
    }

    // get single order
    public Order getOrder(int orderId){
        Order order =  orderRepo.findById(orderId).orElseThrow(ExceptionHandler::throwResourceNotFoundException);
        return order;
    }

    // delete order
    public boolean deleteOrder(int orderId){
        Order order = orderRepo.findById(orderId).orElseThrow(ExceptionHandler::throwResourceNotFoundException);
        orderRepo.delete(order);
        return true;
    }

}

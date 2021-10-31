package com.example.orderservice.controller;

import com.example.orderservice.entity.Order;
import com.example.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/")
    Order savOrder(@RequestBody Order order){
        return orderService.saveOrder(order);
    }

    @GetMapping("/{id}")
    Order findOrderById(@PathVariable("id") Long id){
        return orderService.findOrderById(id);
    }

    @GetMapping("/")
    List<Order> findAllOrders(){
        return orderService.findAllOrders();
    }
}

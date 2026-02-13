package com.eoms.order_service.controller;

import com.eoms.order_service.dto.CreateOrderRequest;
import com.eoms.order_service.model.Order;
import com.eoms.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Order create(@RequestBody CreateOrderRequest req) {
        return orderService.createOrder(req);
    }

    @GetMapping("/user/{userId}")
    public List<Order> getUserOrders(@PathVariable String userId) {
        return orderService.getOrdersByUser(userId);
    }
}


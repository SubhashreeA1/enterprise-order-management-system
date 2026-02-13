package com.eoms.order_service.service;

import com.eoms.order_service.dto.CreateOrderRequest;
import com.eoms.order_service.model.Order;
import com.eoms.order_service.model.OrderStatus;
import com.eoms.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order createOrder(CreateOrderRequest req) {
        Order order = new Order();
        order.setUserId(req.userId());
        order.setProductName(req.productName());
        order.setQuantity(req.quantity());
        order.setStatus(OrderStatus.CREATED);
        order.setCreatedAt(LocalDateTime.now());

        return orderRepository.save(order);
    }

    public List<Order> getOrdersByUser(String userId) {
        return orderRepository.findByUserId(userId);
    }
}


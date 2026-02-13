package com.eoms.order_service.dto;

public record CreateOrderRequest(
        String userId,
        String productName,
        int quantity
) {}

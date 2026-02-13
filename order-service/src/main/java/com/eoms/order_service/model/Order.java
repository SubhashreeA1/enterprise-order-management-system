package com.eoms.order_service.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue
    private UUID id;

    private String userId;
    private String productName;
    private int quantity;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private LocalDateTime createdAt;
}



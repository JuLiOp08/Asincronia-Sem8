package com.example.eventosconwhereby.domain;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter

public class OrderCreatedEvent extends ApplicationEvent {
    private final String orderId;
    private final String email;
    private final String productList;

    public OrderCreatedEvent(Object source, String orderId, String email, String productList) {
        super(source);
        this.orderId = orderId;
        this.email = email;
        this.productList = productList;
    }
}


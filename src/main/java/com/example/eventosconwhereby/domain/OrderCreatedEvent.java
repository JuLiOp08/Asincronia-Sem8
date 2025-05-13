package com.example.eventosconwhereby.domain;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import java.util.List;

@Getter
public class OrderCreatedEvent extends ApplicationEvent {

    private final Long orderId;
    private final String email;
    private final List<String> products;

    public OrderCreatedEvent(Object source, Long orderId, String email, List<String> products) {
        super(source);
        this.orderId = orderId;
        this.email = email;
        this.products = products;
    }

}


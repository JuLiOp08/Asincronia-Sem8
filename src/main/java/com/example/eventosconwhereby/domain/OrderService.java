package com.example.eventosconwhereby.domain;

import com.example.eventosconwhereby.domain.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public OrderService(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void createOrder(OrderDto orderDto) {
        // Validar datos del pedido (opcional)
        if (orderDto.getOrderId() == null || orderDto.getEmail() == null || orderDto.getProducts() == null) {
            throw new IllegalArgumentException("Order ID, email y lista de productos son requeridos.");
        }

        // Publicar evento de creación de pedido
        OrderCreatedEvent event = new OrderCreatedEvent(this, orderDto.getOrderId(), orderDto.getEmail(), orderDto.getProducts());
        eventPublisher.publishEvent(event);
    }
}
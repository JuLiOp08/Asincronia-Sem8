package com.example.eventosconwhereby.application;

import com.example.eventosconwhereby.domain.OrderCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public OrderController(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @PostMapping
    public String createOrder(@RequestParam String orderId, @RequestParam String email, @RequestParam String productList) {
        // Publicando el evento OrderCreatedEvent
        OrderCreatedEvent event = new OrderCreatedEvent(this, orderId, email, productList);
        eventPublisher.publishEvent(event);
        return "Evento " + event + " creado";
    }
}
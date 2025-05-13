package com.example.eventosconwhereby.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody SpringDataJaxb.OrderDto dto) {
        // imular guardado
        Long generatedOrderId = new Random().nextLong();

        eventPublisher.publishEvent(new OrderCreatedEvent(this, generatedOrderId, dto.getEmail(), dto.getProducts()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
package com.example.eventosconwhereby.application;

import com.example.eventosconwhereby.domain.OrderDto;
import com.example.eventosconwhereby.domain.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public void createOrder(@RequestBody OrderDto orderDto) {
        // Delegar la lógica al servicio
        orderService.createOrder(orderDto);
    }
}

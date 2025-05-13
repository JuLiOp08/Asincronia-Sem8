package com.example.eventosconwhereby.domain.Listener;

import com.example.eventosconwhereby.domain.OrderCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class InventoryUpdateListener {

    private static final Logger logger = LoggerFactory.getLogger(InventoryUpdateListener.class);

    @Async
    @EventListener
    public void actualizarInventario(OrderCreatedEvent evento) {
        logger.info("Reduciendo stock para productos: {}", evento.getProducts());
    }
}
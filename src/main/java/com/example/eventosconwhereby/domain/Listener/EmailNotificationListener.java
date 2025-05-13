package com.example.eventosconwhereby.domain.Listener;

import com.example.eventosconwhereby.domain.OrderCreatedEvent;
import org.springframework.context.event.EventListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationListener {
    private static final Logger logger = LogManager.getLogger(EmailNotificationListener.class);

    @EventListener
    public void handleOrderCreatedEvent(OrderCreatedEvent event) {
        logger.info("Enviando correo a: {} - Pedido ID: {} - Productos: {}",
            event.getEmail(),
            event.getOrderId(),
            event.getProductList());
    }
}
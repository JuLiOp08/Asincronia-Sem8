package com.example.eventosconwhereby.domain.Listener;

import com.example.eventosconwhereby.domain.OrderCreatedEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AuditLogListener {

    private static final Logger logger = LogManager.getLogger(AuditLogListener.class);

    @EventListener
    public void handleOrderCreatedEvent(OrderCreatedEvent event) {
        logger.info("[AuditLog] Pedido registrado: ID={}, Email={}, Productos={}",
                event.getOrderId(), event.getEmail(), event.getProductList());
        logger.info("[AuditLog] Evento manejado por AuditLogListener correctamente.");
    }

}

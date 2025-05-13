package com.example.eventosconwhereby.domain.Listener;

import com.example.eventosconwhereby.domain.OrderCreatedEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class InventoryUpdateListener {

    private static final Logger logger = LogManager.getLogger(InventoryUpdateListener.class);

    @EventListener
    public void handleOrderCreatedEvent(OrderCreatedEvent event) {
        String[] productos = event.getProductList().split(",");

        for (String producto : productos) {
            logger.info("[InventoryUpdate] Reduciendo stock del producto: {}", producto.trim());
        }

        // Log adicional para confirmar ejecución
        logger.info("[InventoryUpdate] Evento manejado por InventoryUpdateListener correctamente.");
    }
}
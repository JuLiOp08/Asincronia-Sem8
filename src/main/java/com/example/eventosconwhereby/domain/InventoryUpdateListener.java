package com.example.eventosconwhereby.domain.Listener;

import com.example.eventosconwhereby.domain.OrderCreatedEvent;
import org.springframework.context.event.EventListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InventoryUpdateListener {
    private static final Logger logger = LogManager.getLogger(InventoryUpdateListener.class);

    @EventListener
    public void handleOrderCreatedEvent(OrderCreatedEvent event) {
        logger.info("Actualizando stock para los productos: {}", event.getProductList());
        // Lógica para reducir stock en base de datos...

        try {
            // Simulación de actualización de stock
            String[] productos = event.getProductList().split(",");
            for (String producto : productos) {
                logger.info("Reduciendo stock para el producto: {}", producto.trim());
                // Aquí iría la lógica para actualizar el stock en la base de datos
                // Por ejemplo: inventoryService.updateStock(producto.trim());
            }
            logger.info("Stock actualizado correctamente.");
        } catch (Exception e) {
            logger.error("Error al actualizar el stock: {}", e.getMessage(), e);
        }

    }
}

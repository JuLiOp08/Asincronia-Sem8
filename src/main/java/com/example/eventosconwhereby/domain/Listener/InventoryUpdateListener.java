package com.example.eventosconwhereby.domain.Listener;

import com.example.eventosconwhereby.domain.OrderCreatedEvent;
import com.example.eventosconwhereby.domain.Producto;
import com.example.eventosconwhereby.infrastrucutre.StockRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InventoryUpdateListener {

    private static final Logger logger = LogManager.getLogger(InventoryUpdateListener.class);

    private final StockRepository stockRepository;

    @Autowired
    public InventoryUpdateListener(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @EventListener
    public void handleOrderCreatedEvent(OrderCreatedEvent event) {
        List<String> products = event.getProducts();

        for (String productName : products) {
            stockRepository.save(new Producto(productName, 3));
        }
        
        for (String productName : products) {
             // Asegurarse de que el producto existe en la base de datos
            stockRepository.findByName(productName).ifPresentOrElse(
                    product -> {
                        int beforeStock = product.getStock();
                        product.reduceStock(1); // Reduce en 1 cada producto
                        stockRepository.save(product);
                        logger.info("[InventoryUpdate] Stock reducido para producto: {}. Stock antes: {}, Stock después: {}", product.getName(), beforeStock, product.getStock());
                    },
                    () -> logger.warn("[InventoryUpdate] Producto no encontrado: {}", productName)
            );
        }

        // Log adicional para confirmar ejecución
        logger.info("[InventoryUpdate] Evento manejado por InventoryUpdateListener correctamente.");
    }
}


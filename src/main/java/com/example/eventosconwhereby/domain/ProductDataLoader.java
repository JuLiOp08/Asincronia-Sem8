package com.example.eventosconwhereby.domain;

import com.example.eventosconwhereby.domain.Producto;
import com.example.eventosconwhereby.infrastrucutre.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductDataLoader implements CommandLineRunner {

    private final StockRepository stockRepository;

    @Autowired
    public ProductDataLoader(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Agregar productos iniciales solo si no existen
        if (stockRepository.findByName("Hola").isEmpty()) {
            stockRepository.save(new Producto("Hola", 10));
        }

        if (stockRepository.findByName("adios").isEmpty()) {
            stockRepository.save(new Producto("adios", 15));
        }

        System.out.println("Productos iniciales cargados en la base de datos.");
    }
}

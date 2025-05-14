package com.example.eventosconwhereby.domain;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int stock;

    // ✅ Constructor por defecto (necesario para JPA)
    public Producto() {}

    // ✅ Constructor con parámetros
    public Producto(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    public void reduceStock(int amount) {
        if (this.stock - amount >= 0) {
            this.stock -= amount;
        } else {
            throw new IllegalArgumentException("No hay suficiente stock disponible.");
        }
    }
}

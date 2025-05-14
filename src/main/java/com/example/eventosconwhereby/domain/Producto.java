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

    public Producto(String name_, int stock_) {
        this.name = name_;
        this.stock = stock_;
    }

    public void reduceStock(int amount) {
        if (stock - amount >= 0) {
            this.stock -= amount;
        } else {
            throw new IllegalArgumentException("No hay suficiente stock disponible.");
        }
    }
}

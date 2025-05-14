package com.example.eventosconwhereby.infrastrucutre;

import com.example.eventosconwhereby.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Producto, Long> {
    Optional<Producto> findByName(String name);
}

package com.example.pintureriadelsur.Producto.Repository;
import java.util.List;

import com.example.pintureriadelsur.Producto.Entity.Producto;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    @Query("SELECT p FROM Producto p WHERE " +
            "(:nombre IS NULL OR :nombre = '' OR LOWER(p.nombre) LIKE LOWER(:nombre)) AND " +
            "(:marcaId IS NULL OR p.marca.id = :marcaId) AND " +
            "(:precioMin IS NULL OR p.precio >= :precioMin) AND " +
            "(:precioMax IS NULL OR p.precio <= :precioMax)")
    List<Producto> filtrarProductos(
            @Param("nombre") String nombre,
            @Param("marcaId") Long marcaId,
            @Param("precioMin") BigDecimal precioMin,
            @Param("precioMax") BigDecimal precioMax);
}

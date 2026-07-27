package org.example.pintureria.Producto.Repository;

import org.example.pintureria.Producto.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}

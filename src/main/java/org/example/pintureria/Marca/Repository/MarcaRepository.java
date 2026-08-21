package org.example.pintureria.Marca.Repository;

import org.example.pintureria.Marca.Entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
}
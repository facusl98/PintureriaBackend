package com.example.pintureriadelsur.Marca.Repository;

import com.example.pintureriadelsur.Marca.Entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
}
package com.example.pintureriadelsur.Producto.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.example.pintureriadelsur.Marca.Entity.Marca;
import lombok.Data;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "marca_id", nullable = false)
    private Marca marca;

    private String nombre;

    private BigDecimal precio;

    private String descripcion;

    private Integer stock;

    private String imagenUrl;

}
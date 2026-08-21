package com.example.pintureriadelsur.Producto.Service;

import com.example.pintureriadelsur.Producto.Entity.Producto;
import com.example.pintureriadelsur.Producto.Repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public List<Producto> listar() {
        return repository.findAll();
    }

    public List<Producto> listarConFiltros(String nombre, Long marcaId, BigDecimal precioMin, BigDecimal precioMax) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            nombre = "%" + nombre + "%";
        }
        return repository.filtrarProductos(nombre, marcaId, precioMin, precioMax);
    }

    public Optional<Producto> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Producto guardar(Producto producto) {
        return repository.save(producto);
    }

    public Producto actualizar(Long id, Producto productoActualizado) {

        Producto producto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        producto.setNombre(productoActualizado.getNombre());
        producto.setPrecio(productoActualizado.getPrecio());
        producto.setDescripcion(productoActualizado.getDescripcion());
        producto.setStock(productoActualizado.getStock());
        producto.setImagenUrl(productoActualizado.getImagenUrl());
        producto.setMarca(productoActualizado.getMarca());

        return repository.save(producto);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}

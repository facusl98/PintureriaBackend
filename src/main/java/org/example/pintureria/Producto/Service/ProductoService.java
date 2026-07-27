package org.example.pintureria.Producto.Service;

import org.example.pintureria.Marca.Entity.Marca;
import org.example.pintureria.Producto.Entity.Producto;
import org.example.pintureria.Producto.Repository.ProductoRepository;
import org.springframework.stereotype.Service;

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

        return repository.save(producto);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}

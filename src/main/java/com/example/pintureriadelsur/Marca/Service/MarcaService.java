package com.example.pintureriadelsur.Marca.Service;

import com.example.pintureriadelsur.Marca.Repository.MarcaRepository;
import com.example.pintureriadelsur.Marca.Entity.Marca;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaService {

    private final MarcaRepository repository;

    public MarcaService(MarcaRepository repository) {
        this.repository = repository;
    }

    public List<Marca> listar() {
        return repository.findAll();
    }

    public Optional<Marca> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Marca guardar(Marca marca) {
        return repository.save(marca);
    }

    public Marca actualizar(Long id, Marca marcaActualizada) {

        Marca marca = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Marca no encontrada"));

        marca.setNombre(marcaActualizada.getNombre());

        return repository.save(marca);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
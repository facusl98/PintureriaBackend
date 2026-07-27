package org.example.pintureria.Marca.Controller;

import org.example.pintureria.Marca.Entity.Marca;
import org.example.pintureria.Marca.Service.MarcaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

    private final MarcaService service;

    public MarcaController(MarcaService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<Marca>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> obtenerPorId(@PathVariable Long id) {

        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Marca> guardar(@RequestBody Marca marca) {

        Marca nuevaMarca = service.guardar(marca);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(nuevaMarca);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marca> actualizar(
            @PathVariable Long id,
            @RequestBody Marca marca) {

        Marca actualizada = service.actualizar(id, marca);

        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        service.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}

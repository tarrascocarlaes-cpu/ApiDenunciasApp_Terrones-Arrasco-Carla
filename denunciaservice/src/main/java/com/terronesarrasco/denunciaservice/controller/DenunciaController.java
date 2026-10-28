package com.terronesarrasco.denunciaservice.controller;

import com.terronesarrasco.denunciaservice.entity.Denuncia;
import com.terronesarrasco.denunciaservice.service.DenunciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/denuncias", "/denuncias/"})
public class DenunciaController {

    private final DenunciaService service;

    public DenunciaController(DenunciaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Denuncia> registrar(@RequestBody Denuncia denuncia) {
        return ResponseEntity.ok(service.registrar(denuncia));
    }

    @GetMapping
    public ResponseEntity<List<Denuncia>> obtenerTodas(
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "5") int limit) {
        return ResponseEntity.ok(service.obtenerTodas(offset, limit));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Denuncia> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @GetMapping("/ciudadano/{dni}")
    public ResponseEntity<List<Denuncia>> obtenerPorCiudadano(@PathVariable String dni) {
        return ResponseEntity.ok(service.obtenerPorCiudadano(dni));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Denuncia> atender(@PathVariable Integer id) {
        return ResponseEntity.ok(service.atender(id));
    }
}

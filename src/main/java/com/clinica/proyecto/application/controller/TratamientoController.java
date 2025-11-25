package com.clinica.proyecto.application.controller;

import com.clinica.proyecto.application.dto.TratamientoDTO;
import com.clinica.proyecto.application.service.TratamientoService;
import com.clinica.proyecto.infraestructure.modelo.Tratamiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tratamientos")
@CrossOrigin(origins = "*")
public class TratamientoController {
    @Autowired
    private TratamientoService tratamientoService;

    @GetMapping("/historia/{historiaId}")
    public ResponseEntity<List<TratamientoDTO>> listarPorHistoria(@PathVariable Long historiaId) {
        return ResponseEntity.ok(tratamientoService.listarPorHistoria(historiaId));
    }

    @PostMapping
    public ResponseEntity<TratamientoDTO> crear(@RequestBody TratamientoDTO body) {
        Tratamiento creado = tratamientoService.crearDesdeDTO(body);
        TratamientoDTO dto = new TratamientoDTO();
        dto.setId(creado.getId());
        dto.setHistoriaClinicaId(creado.getHistoriaClinica().getId());
        dto.setDescripcion(creado.getDescripcion());
        dto.setFecha(creado.getFecha());
        dto.setDoctorId(creado.getDoctor().getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TratamientoDTO> buscar(@PathVariable Long id) {
        Optional<TratamientoDTO> dto = tratamientoService.buscar(id);
        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}


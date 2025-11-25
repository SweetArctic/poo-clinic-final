package com.clinica.proyecto.application.controller;

import com.clinica.proyecto.application.dto.PacienteDTO;
import com.clinica.proyecto.application.service.PacienteService;
import com.clinica.proyecto.infraestructure.modelo.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin(origins = "*")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<PacienteDTO>> listar() {
        return ResponseEntity.ok(pacienteService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> buscar(@PathVariable Long id) {
        return pacienteService.buscar(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PacienteDTO> crear(@RequestBody PacienteDTO body) {
        Paciente creado = pacienteService.crearDesdeDTO(body);
        PacienteDTO dto = new PacienteDTO();
        dto.setId(creado.getId());
        dto.setNombre(creado.getNombre());
        dto.setEmail(creado.getEmail());
        dto.setTelefono(creado.getTelefono());
        dto.setFechaNacimiento(creado.getFechaNacimiento());
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteDTO> actualizar(@PathVariable Long id, @RequestBody PacienteDTO body) {
        Optional<Paciente> actualizado = pacienteService.actualizarDesdeDTO(id, body);
        return actualizado.map(p -> {
            PacienteDTO dto = new PacienteDTO();
            dto.setId(p.getId());
            dto.setNombre(p.getNombre());
            dto.setEmail(p.getEmail());
            dto.setTelefono(p.getTelefono());
            dto.setFechaNacimiento(p.getFechaNacimiento());
            return ResponseEntity.ok(dto);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean ok = pacienteService.eliminar(id);
        if (ok) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}


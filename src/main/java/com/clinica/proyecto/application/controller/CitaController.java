package com.clinica.proyecto.application.controller;

import com.clinica.proyecto.application.dto.CitaDTO;
import com.clinica.proyecto.application.service.CitaService;
import com.clinica.proyecto.infraestructure.modelo.Cita;
import com.clinica.proyecto.infraestructure.modelo.enums.EstadoCita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/citas")
@CrossOrigin(origins = "*")
public class CitaController {
    @Autowired
    private CitaService citaService;

    @GetMapping
    public ResponseEntity<List<CitaDTO>> listar() { return ResponseEntity.ok(citaService.listar()); }

    @GetMapping("/{id}")
    public ResponseEntity<CitaDTO> buscar(@PathVariable Long id) {
        return citaService.buscar(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CitaDTO> crear(@RequestBody CitaDTO body) {
        Cita creado = citaService.crearDesdeDTO(body);
        CitaDTO dto = new CitaDTO();
        dto.setId(creado.getId());
        dto.setPacienteId(creado.getPaciente().getId());
        dto.setDoctorId(creado.getDoctor().getId());
        dto.setFechaHora(creado.getFechaHora());
        dto.setMotivo(creado.getMotivo());
        dto.setEstado(creado.getEstado().name());
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<CitaDTO> actualizarEstado(@PathVariable Long id, @RequestParam String estado) {
        Optional<Cita> actualizado = citaService.actualizarEstado(id, EstadoCita.valueOf(estado));
        return actualizado.map(c -> {
            CitaDTO dto = new CitaDTO();
            dto.setId(c.getId());
            dto.setPacienteId(c.getPaciente().getId());
            dto.setDoctorId(c.getDoctor().getId());
            dto.setFechaHora(c.getFechaHora());
            dto.setMotivo(c.getMotivo());
            dto.setEstado(c.getEstado().name());
            return ResponseEntity.ok(dto);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<CitaDTO>> listarPorDoctor(@PathVariable Long doctorId) {
        return ResponseEntity.ok(citaService.listarPorDoctor(doctorId));
    }

    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<CitaDTO>> listarPorPaciente(@PathVariable Long pacienteId) {
        return ResponseEntity.ok(citaService.listarPorPaciente(pacienteId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean ok = citaService.eliminar(id);
        if (ok) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}


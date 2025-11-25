package com.clinica.proyecto.application.controller;

import com.clinica.proyecto.application.dto.DoctorDTO;
import com.clinica.proyecto.application.service.DoctorService;
import com.clinica.proyecto.infraestructure.modelo.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctores")
@CrossOrigin(origins = "*")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<DoctorDTO>> listar() { return ResponseEntity.ok(doctorService.listar()); }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTO> buscar(@PathVariable Long id) {
        return doctorService.buscar(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DoctorDTO> crear(@RequestBody DoctorDTO body) {
        Doctor creado = doctorService.crearDesdeDTO(body);
        DoctorDTO dto = new DoctorDTO();
        dto.setId(creado.getId());
        dto.setNombre(creado.getNombre());
        dto.setEspecialidad(creado.getEspecialidad());
        dto.setEmail(creado.getEmail());
        dto.setTelefono(creado.getTelefono());
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorDTO> actualizar(@PathVariable Long id, @RequestBody DoctorDTO body) {
        Optional<Doctor> actualizado = doctorService.actualizarDesdeDTO(id, body);
        return actualizado.map(d -> {
            DoctorDTO dto = new DoctorDTO();
            dto.setId(d.getId());
            dto.setNombre(d.getNombre());
            dto.setEspecialidad(d.getEspecialidad());
            dto.setEmail(d.getEmail());
            dto.setTelefono(d.getTelefono());
            return ResponseEntity.ok(dto);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean ok = doctorService.eliminar(id);
        if (ok) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}


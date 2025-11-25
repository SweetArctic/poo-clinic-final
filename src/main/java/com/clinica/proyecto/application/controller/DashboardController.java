package com.clinica.proyecto.application.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.proyecto.application.dto.CitaDTO;
import com.clinica.proyecto.application.dto.DoctorDTO;
import com.clinica.proyecto.application.dto.HistoriaClinicaDTO;
import com.clinica.proyecto.application.dto.PacienteDTO;
import com.clinica.proyecto.application.dto.TratamientoDTO;
import com.clinica.proyecto.application.service.CitaService;
import com.clinica.proyecto.application.service.DoctorService;
import com.clinica.proyecto.application.service.HistoriaClinicaService;
import com.clinica.proyecto.application.service.PacienteService;
import com.clinica.proyecto.application.service.TratamientoService;
import com.clinica.proyecto.infraestructure.modelo.Cita;
import com.clinica.proyecto.infraestructure.modelo.Doctor;
import com.clinica.proyecto.infraestructure.modelo.Paciente;
import com.clinica.proyecto.infraestructure.modelo.enums.EstadoCita;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "*")
public class DashboardController {
    @Autowired private DoctorService doctorService;
    @Autowired private PacienteService pacienteService;
    @Autowired private CitaService citaService;
    @Autowired private TratamientoService tratamientoService;
    @Autowired private HistoriaClinicaService historiaClinicaService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> dashboard() {
        Map<String, Object> info = new HashMap<>();
        info.put("status", "ok");
        info.put("message", "Dashboard de Clínica listo");
        info.put("resources", List.of(
                "/api/dashboard/doctores",
                "/api/dashboard/pacientes",
                "/api/dashboard/citas",
                "/api/dashboard/tratamientos",
                "/api/dashboard/historias"
        ));
        info.put("counts", Map.of(
                "doctores", doctorService.listar().size(),
                "pacientes", pacienteService.listar().size(),
                "citas", citaService.listar().size()
        ));
        return ResponseEntity.ok(info);
    }

    @GetMapping("/doctores")
    public ResponseEntity<List<DoctorDTO>> listarDoctores() { return ResponseEntity.ok(doctorService.listar()); }
    @GetMapping("/doctores/{id}")
    public ResponseEntity<DoctorDTO> buscarDoctor(@PathVariable Long id) { return doctorService.buscar(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()); }
    @PostMapping("/doctores")
    public ResponseEntity<DoctorDTO> crearDoctor(@RequestBody DoctorDTO body) {
        Doctor creado = doctorService.crearDesdeDTO(body);
        DoctorDTO dto = new DoctorDTO();
        dto.setId(creado.getId());
        dto.setNombre(creado.getNombre());
        dto.setEspecialidad(creado.getEspecialidad());
        dto.setEmail(creado.getEmail());
        dto.setTelefono(creado.getTelefono());
        return ResponseEntity.created(URI.create("/api/dashboard/doctores/" + dto.getId())).body(dto);
    }

    @GetMapping("/auth-check")
    public ResponseEntity<Map<String, String>> authCheck() {
        return ResponseEntity.ok(Map.of("status", "authenticated"));
    }
    @PutMapping("/doctores/{id}")
    public ResponseEntity<DoctorDTO> actualizarDoctor(@PathVariable Long id, @RequestBody DoctorDTO body) {
        Optional<Doctor> act = doctorService.actualizarDesdeDTO(id, body);
        return act.map(d -> {
            DoctorDTO dto = new DoctorDTO();
            dto.setId(d.getId());
            dto.setNombre(d.getNombre());
            dto.setEspecialidad(d.getEspecialidad());
            dto.setEmail(d.getEmail());
            dto.setTelefono(d.getTelefono());
            return ResponseEntity.ok(dto);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/doctores/{id}")
    public ResponseEntity<Void> eliminarDoctor(@PathVariable Long id) {
        boolean ok = doctorService.eliminar(id);
        if (ok) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/pacientes")
    public ResponseEntity<List<PacienteDTO>> listarPacientes() { return ResponseEntity.ok(pacienteService.listar()); }
    @GetMapping("/pacientes/{id}")
    public ResponseEntity<PacienteDTO> buscarPaciente(@PathVariable Long id) { return pacienteService.buscar(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()); }
    @PostMapping("/pacientes")
    public ResponseEntity<PacienteDTO> crearPaciente(@RequestBody PacienteDTO body) {
        Paciente creado = pacienteService.crearDesdeDTO(body);
        PacienteDTO dto = new PacienteDTO();
        dto.setId(creado.getId());
        dto.setNombre(creado.getNombre());
        dto.setEmail(creado.getEmail());
        dto.setTelefono(creado.getTelefono());
        dto.setFechaNacimiento(creado.getFechaNacimiento());
        return ResponseEntity.created(URI.create("/api/dashboard/pacientes/" + dto.getId())).body(dto);
    }
    @PutMapping("/pacientes/{id}")
    public ResponseEntity<PacienteDTO> actualizarPaciente(@PathVariable Long id, @RequestBody PacienteDTO body) {
        Optional<Paciente> act = pacienteService.actualizarDesdeDTO(id, body);
        return act.map(p -> {
            PacienteDTO dto = new PacienteDTO();
            dto.setId(p.getId());
            dto.setNombre(p.getNombre());
            dto.setEmail(p.getEmail());
            dto.setTelefono(p.getTelefono());
            dto.setFechaNacimiento(p.getFechaNacimiento());
            return ResponseEntity.ok(dto);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/pacientes/{id}")
    public ResponseEntity<Void> eliminarPaciente(@PathVariable Long id) {
        boolean ok = pacienteService.eliminar(id);
        if (ok) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/citas")
    public ResponseEntity<List<CitaDTO>> listarCitas() { return ResponseEntity.ok(citaService.listar()); }
    @GetMapping("/citas/{id}")
    public ResponseEntity<CitaDTO> buscarCita(@PathVariable Long id) { return citaService.buscar(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()); }
    @PostMapping("/citas")
    public ResponseEntity<CitaDTO> crearCita(@RequestBody CitaDTO body) {
        Cita creado = citaService.crearDesdeDTO(body);
        CitaDTO dto = new CitaDTO();
        dto.setId(creado.getId());
        dto.setPacienteId(creado.getPaciente().getId());
        dto.setDoctorId(creado.getDoctor().getId());
        dto.setFechaHora(creado.getFechaHora());
        dto.setMotivo(creado.getMotivo());
        dto.setEstado(creado.getEstado().name());
        return ResponseEntity.created(URI.create("/api/dashboard/citas/" + dto.getId())).body(dto);
    }
    @PutMapping("/citas/{id}/estado")
    public ResponseEntity<CitaDTO> actualizarEstadoCita(@PathVariable Long id, @RequestParam String estado) {
        Optional<Cita> act = citaService.actualizarEstado(id, EstadoCita.valueOf(estado));
        return act.map(c -> {
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
    @GetMapping("/citas/doctor/{doctorId}")
    public ResponseEntity<List<CitaDTO>> listarCitasPorDoctor(@PathVariable Long doctorId) { return ResponseEntity.ok(citaService.listarPorDoctor(doctorId)); }
    @GetMapping("/citas/paciente/{pacienteId}")
    public ResponseEntity<List<CitaDTO>> listarCitasPorPaciente(@PathVariable Long pacienteId) { return ResponseEntity.ok(citaService.listarPorPaciente(pacienteId)); }
    @DeleteMapping("/citas/{id}")
    public ResponseEntity<Void> eliminarCita(@PathVariable Long id) {
        boolean ok = citaService.eliminar(id);
        if (ok) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/tratamientos/historia/{historiaId}")
    public ResponseEntity<List<TratamientoDTO>> listarTratamientosPorHistoria(@PathVariable Long historiaId) { return ResponseEntity.ok(tratamientoService.listarPorHistoria(historiaId)); }
    @PostMapping("/tratamientos")
    public ResponseEntity<TratamientoDTO> crearTratamiento(@RequestBody TratamientoDTO body) {
        var creado = tratamientoService.crearDesdeDTO(body);
        TratamientoDTO dto = new TratamientoDTO();
        dto.setId(creado.getId());
        dto.setHistoriaClinicaId(creado.getHistoriaClinica().getId());
        dto.setDescripcion(creado.getDescripcion());
        dto.setFecha(creado.getFecha());
        dto.setDoctorId(creado.getDoctor().getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }
    @GetMapping("/tratamientos/{id}")
    public ResponseEntity<TratamientoDTO> buscarTratamiento(@PathVariable Long id) {
        Optional<TratamientoDTO> dto = tratamientoService.buscar(id);
        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/historias/paciente/{pacienteId}")
    public ResponseEntity<HistoriaClinicaDTO> buscarHistoriaPorPaciente(@PathVariable Long pacienteId) {
        Optional<HistoriaClinicaDTO> dto = historiaClinicaService.buscarPorPaciente(pacienteId);
        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/historias/paciente/{pacienteId}")
    public ResponseEntity<HistoriaClinicaDTO> crearHistoriaParaPaciente(@PathVariable Long pacienteId) {
        var creada = historiaClinicaService.crearParaPaciente(pacienteId);
        HistoriaClinicaDTO dto = new HistoriaClinicaDTO();
        dto.setPacienteId(creada.getPaciente().getId());
        dto.setId(creada.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }
}


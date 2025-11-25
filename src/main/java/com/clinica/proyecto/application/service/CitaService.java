package com.clinica.proyecto.application.service;

import com.clinica.proyecto.application.dto.CitaDTO;
import com.clinica.proyecto.application.mapper.CitaMapper;
import com.clinica.proyecto.application.repository.ICitaRepository;
import com.clinica.proyecto.infraestructure.modelo.Cita;
import com.clinica.proyecto.infraestructure.modelo.enums.EstadoCita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaService {
    @Autowired
    private ICitaRepository citaRepository;

    @Autowired
    private CitaMapper citaMapper;

    public List<CitaDTO> listar() { return citaRepository.findAllDTO(); }
    public Optional<CitaDTO> buscar(Long id) { return citaRepository.findByIdDTO(id); }
    public Cita crearDesdeDTO(CitaDTO dto) { return citaRepository.save(citaMapper.toEntity(dto)); }
    public Optional<Cita> actualizarEstado(Long id, EstadoCita estado) {
        return citaRepository.findById(id).map(c -> {
            c.setEstado(estado);
            return citaRepository.save(c);
        });
    }
    public List<CitaDTO> listarPorDoctor(Long doctorId) { return citaRepository.findByDoctorIdDTO(doctorId); }
    public List<CitaDTO> listarPorPaciente(Long pacienteId) { return citaRepository.findByPacienteIdDTO(pacienteId); }
    public boolean eliminar(Long id) {
        Optional<Cita> c = citaRepository.findById(id);
        if (c.isPresent()) { citaRepository.deleteById(id); return true; }
        return false;
    }
}


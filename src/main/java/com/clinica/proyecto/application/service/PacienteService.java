package com.clinica.proyecto.application.service;

import com.clinica.proyecto.application.dto.PacienteDTO;
import com.clinica.proyecto.application.mapper.PacienteMapper;
import com.clinica.proyecto.application.repository.IPacienteRepository;
import com.clinica.proyecto.infraestructure.modelo.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    private PacienteMapper pacienteMapper;

    public List<PacienteDTO> listar() {
        return pacienteRepository.findAllDTO();
    }

    public Optional<PacienteDTO> buscar(Long id) {
        return pacienteRepository.findByIdDTO(id);
    }

    public Paciente crearDesdeDTO(PacienteDTO dto) {
        return pacienteRepository.save(pacienteMapper.toEntity(dto));
    }

    public Optional<Paciente> actualizarDesdeDTO(Long id, PacienteDTO dto) {
        return pacienteRepository.findById(id).map(p -> {
            p.setNombre(dto.getNombre());
            p.setEmail(dto.getEmail());
            p.setTelefono(dto.getTelefono());
            p.setFechaNacimiento(dto.getFechaNacimiento());
            return pacienteRepository.save(p);
        });
    }

    public boolean eliminar(Long id) {
        Optional<Paciente> p = pacienteRepository.findById(id);
        if (p.isPresent()) {
            pacienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}


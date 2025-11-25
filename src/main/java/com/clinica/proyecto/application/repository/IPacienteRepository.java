package com.clinica.proyecto.application.repository;

import com.clinica.proyecto.application.dto.PacienteDTO;
import com.clinica.proyecto.infraestructure.modelo.Paciente;
import java.util.List;
import java.util.Optional;

public interface IPacienteRepository {
    List<Paciente> findAll();
    Optional<Paciente> findById(Long id);
    Paciente save(Paciente paciente);
    void deleteById(Long id);

    List<PacienteDTO> findAllDTO();
    Optional<PacienteDTO> findByIdDTO(Long id);
    PacienteDTO saveDTO(PacienteDTO pacienteDTO);
    void deleteByIdDTO(Long id);
}


package com.clinica.proyecto.application.repository;

import com.clinica.proyecto.application.dto.HistoriaClinicaDTO;
import com.clinica.proyecto.infraestructure.modelo.HistoriaClinica;
import java.util.List;
import java.util.Optional;

public interface IHistoriaClinicaRepository {
    List<HistoriaClinica> findAll();
    Optional<HistoriaClinica> findById(Long id);
    HistoriaClinica save(HistoriaClinica historiaClinica);
    Optional<HistoriaClinica> findByPacienteId(Long pacienteId);

    List<HistoriaClinicaDTO> findAllDTO();
    Optional<HistoriaClinicaDTO> findByIdDTO(Long id);
    HistoriaClinicaDTO saveDTO(HistoriaClinicaDTO historiaClinicaDTO);
    Optional<HistoriaClinicaDTO> findByPacienteIdDTO(Long pacienteId);
}


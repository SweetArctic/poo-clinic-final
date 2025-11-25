package com.clinica.proyecto.application.repository;

import com.clinica.proyecto.application.dto.CitaDTO;
import com.clinica.proyecto.infraestructure.modelo.Cita;
import java.util.List;
import java.util.Optional;

public interface ICitaRepository {
    List<Cita> findAll();
    Optional<Cita> findById(Long id);
    Cita save(Cita cita);
    void deleteById(Long id);
    List<Cita> findByDoctorId(Long doctorId);
    List<Cita> findByPacienteId(Long pacienteId);

    List<CitaDTO> findAllDTO();
    Optional<CitaDTO> findByIdDTO(Long id);
    CitaDTO saveDTO(CitaDTO citaDTO);
    void deleteByIdDTO(Long id);
    List<CitaDTO> findByDoctorIdDTO(Long doctorId);
    List<CitaDTO> findByPacienteIdDTO(Long pacienteId);
}


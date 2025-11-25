package com.clinica.proyecto.application.repository;

import com.clinica.proyecto.application.dto.TratamientoDTO;
import com.clinica.proyecto.infraestructure.modelo.Tratamiento;
import java.util.List;
import java.util.Optional;

public interface ITratamientoRepository {
    List<Tratamiento> findAll();
    Optional<Tratamiento> findById(Long id);
    Tratamiento save(Tratamiento tratamiento);
    void deleteById(Long id);
    List<Tratamiento> findByHistoriaClinicaId(Long historiaClinicaId);

    List<TratamientoDTO> findAllDTO();
    Optional<TratamientoDTO> findByIdDTO(Long id);
    TratamientoDTO saveDTO(TratamientoDTO tratamientoDTO);
    void deleteByIdDTO(Long id);
    List<TratamientoDTO> findByHistoriaClinicaIdDTO(Long historiaClinicaId);
}


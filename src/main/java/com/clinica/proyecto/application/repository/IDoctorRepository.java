package com.clinica.proyecto.application.repository;

import com.clinica.proyecto.application.dto.DoctorDTO;
import com.clinica.proyecto.infraestructure.modelo.Doctor;
import java.util.List;
import java.util.Optional;

public interface IDoctorRepository {
    List<Doctor> findAll();
    Optional<Doctor> findById(Long id);
    Doctor save(Doctor doctor);
    void deleteById(Long id);

    List<DoctorDTO> findAllDTO();
    Optional<DoctorDTO> findByIdDTO(Long id);
    DoctorDTO saveDTO(DoctorDTO doctorDTO);
    void deleteByIdDTO(Long id);
}


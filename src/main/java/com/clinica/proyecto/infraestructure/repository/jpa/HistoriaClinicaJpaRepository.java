package com.clinica.proyecto.infraestructure.repository.jpa;

import com.clinica.proyecto.infraestructure.modelo.HistoriaClinica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HistoriaClinicaJpaRepository extends JpaRepository<HistoriaClinica, Long> {
    Optional<HistoriaClinica> findByPaciente_Id(Long pacienteId);
}


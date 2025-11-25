package com.clinica.proyecto.infraestructure.repository.jpa;

import com.clinica.proyecto.infraestructure.modelo.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitaJpaRepository extends JpaRepository<Cita, Long> {
    List<Cita> findByDoctor_Id(Long doctorId);
    List<Cita> findByPaciente_Id(Long pacienteId);
}


package com.clinica.proyecto.infraestructure.repository.jpa;

import com.clinica.proyecto.infraestructure.modelo.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteJpaRepository extends JpaRepository<Paciente, Long> {
}


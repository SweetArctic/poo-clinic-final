package com.clinica.proyecto.infraestructure.repository.jpa;

import com.clinica.proyecto.infraestructure.modelo.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorJpaRepository extends JpaRepository<Doctor, Long> {
}


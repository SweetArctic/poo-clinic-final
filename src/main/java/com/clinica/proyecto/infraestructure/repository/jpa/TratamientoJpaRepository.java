package com.clinica.proyecto.infraestructure.repository.jpa;

import com.clinica.proyecto.infraestructure.modelo.Tratamiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TratamientoJpaRepository extends JpaRepository<Tratamiento, Long> {
    List<Tratamiento> findByHistoriaClinica_Id(Long historiaClinicaId);
}


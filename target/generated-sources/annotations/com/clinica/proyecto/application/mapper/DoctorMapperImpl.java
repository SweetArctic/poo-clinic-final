package com.clinica.proyecto.application.mapper;

import com.clinica.proyecto.application.dto.DoctorDTO;
import com.clinica.proyecto.infraestructure.modelo.Doctor;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-25T01:21:38-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Oracle Corporation)"
)
@Component
public class DoctorMapperImpl implements DoctorMapper {

    @Override
    public DoctorDTO toDTO(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }

        DoctorDTO doctorDTO = new DoctorDTO();

        doctorDTO.setId( doctor.getId() );
        doctorDTO.setNombre( doctor.getNombre() );
        doctorDTO.setEspecialidad( doctor.getEspecialidad() );
        doctorDTO.setEmail( doctor.getEmail() );
        doctorDTO.setTelefono( doctor.getTelefono() );

        return doctorDTO;
    }

    @Override
    public Doctor toEntity(DoctorDTO doctorDTO) {
        if ( doctorDTO == null ) {
            return null;
        }

        Doctor doctor = new Doctor();

        doctor.setId( doctorDTO.getId() );
        doctor.setNombre( doctorDTO.getNombre() );
        doctor.setEspecialidad( doctorDTO.getEspecialidad() );
        doctor.setEmail( doctorDTO.getEmail() );
        doctor.setTelefono( doctorDTO.getTelefono() );

        return doctor;
    }
}

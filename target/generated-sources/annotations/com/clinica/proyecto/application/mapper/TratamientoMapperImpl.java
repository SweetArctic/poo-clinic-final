package com.clinica.proyecto.application.mapper;

import com.clinica.proyecto.application.dto.TratamientoDTO;
import com.clinica.proyecto.infraestructure.modelo.Doctor;
import com.clinica.proyecto.infraestructure.modelo.HistoriaClinica;
import com.clinica.proyecto.infraestructure.modelo.Tratamiento;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-25T02:30:40-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Oracle Corporation)"
)
@Component
public class TratamientoMapperImpl implements TratamientoMapper {

    @Override
    public TratamientoDTO toDTO(Tratamiento tratamiento) {
        if ( tratamiento == null ) {
            return null;
        }

        TratamientoDTO tratamientoDTO = new TratamientoDTO();

        tratamientoDTO.setHistoriaClinicaId( tratamientoHistoriaClinicaId( tratamiento ) );
        tratamientoDTO.setDoctorId( tratamientoDoctorId( tratamiento ) );
        tratamientoDTO.setId( tratamiento.getId() );
        tratamientoDTO.setDescripcion( tratamiento.getDescripcion() );
        tratamientoDTO.setFecha( tratamiento.getFecha() );

        return tratamientoDTO;
    }

    @Override
    public Tratamiento toEntity(TratamientoDTO tratamientoDTO) {
        if ( tratamientoDTO == null ) {
            return null;
        }

        Tratamiento tratamiento = new Tratamiento();

        tratamiento.setHistoriaClinica( tratamientoDTOToHistoriaClinica( tratamientoDTO ) );
        tratamiento.setDoctor( tratamientoDTOToDoctor( tratamientoDTO ) );
        tratamiento.setId( tratamientoDTO.getId() );
        tratamiento.setDescripcion( tratamientoDTO.getDescripcion() );
        tratamiento.setFecha( tratamientoDTO.getFecha() );

        return tratamiento;
    }

    private Long tratamientoHistoriaClinicaId(Tratamiento tratamiento) {
        if ( tratamiento == null ) {
            return null;
        }
        HistoriaClinica historiaClinica = tratamiento.getHistoriaClinica();
        if ( historiaClinica == null ) {
            return null;
        }
        Long id = historiaClinica.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long tratamientoDoctorId(Tratamiento tratamiento) {
        if ( tratamiento == null ) {
            return null;
        }
        Doctor doctor = tratamiento.getDoctor();
        if ( doctor == null ) {
            return null;
        }
        Long id = doctor.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected HistoriaClinica tratamientoDTOToHistoriaClinica(TratamientoDTO tratamientoDTO) {
        if ( tratamientoDTO == null ) {
            return null;
        }

        HistoriaClinica historiaClinica = new HistoriaClinica();

        historiaClinica.setId( tratamientoDTO.getHistoriaClinicaId() );

        return historiaClinica;
    }

    protected Doctor tratamientoDTOToDoctor(TratamientoDTO tratamientoDTO) {
        if ( tratamientoDTO == null ) {
            return null;
        }

        Doctor doctor = new Doctor();

        doctor.setId( tratamientoDTO.getDoctorId() );

        return doctor;
    }
}

package com.clinica.proyecto.application.mapper;

import com.clinica.proyecto.application.dto.CitaDTO;
import com.clinica.proyecto.infraestructure.modelo.Cita;
import com.clinica.proyecto.infraestructure.modelo.Doctor;
import com.clinica.proyecto.infraestructure.modelo.Paciente;
import com.clinica.proyecto.infraestructure.modelo.enums.EstadoCita;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-24T23:23:31-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Oracle Corporation)"
)
@Component
public class CitaMapperImpl implements CitaMapper {

    @Override
    public CitaDTO toDTO(Cita cita) {
        if ( cita == null ) {
            return null;
        }

        CitaDTO citaDTO = new CitaDTO();

        citaDTO.setPacienteId( citaPacienteId( cita ) );
        citaDTO.setDoctorId( citaDoctorId( cita ) );
        if ( cita.getEstado() != null ) {
            citaDTO.setEstado( cita.getEstado().name() );
        }
        citaDTO.setId( cita.getId() );
        citaDTO.setFechaHora( cita.getFechaHora() );
        citaDTO.setMotivo( cita.getMotivo() );

        return citaDTO;
    }

    @Override
    public Cita toEntity(CitaDTO citaDTO) {
        if ( citaDTO == null ) {
            return null;
        }

        Cita cita = new Cita();

        cita.setPaciente( citaDTOToPaciente( citaDTO ) );
        cita.setDoctor( citaDTOToDoctor( citaDTO ) );
        if ( citaDTO.getEstado() != null ) {
            cita.setEstado( Enum.valueOf( EstadoCita.class, citaDTO.getEstado() ) );
        }
        cita.setId( citaDTO.getId() );
        cita.setFechaHora( citaDTO.getFechaHora() );
        cita.setMotivo( citaDTO.getMotivo() );

        return cita;
    }

    private Long citaPacienteId(Cita cita) {
        if ( cita == null ) {
            return null;
        }
        Paciente paciente = cita.getPaciente();
        if ( paciente == null ) {
            return null;
        }
        Long id = paciente.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long citaDoctorId(Cita cita) {
        if ( cita == null ) {
            return null;
        }
        Doctor doctor = cita.getDoctor();
        if ( doctor == null ) {
            return null;
        }
        Long id = doctor.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Paciente citaDTOToPaciente(CitaDTO citaDTO) {
        if ( citaDTO == null ) {
            return null;
        }

        Paciente paciente = new Paciente();

        paciente.setId( citaDTO.getPacienteId() );

        return paciente;
    }

    protected Doctor citaDTOToDoctor(CitaDTO citaDTO) {
        if ( citaDTO == null ) {
            return null;
        }

        Doctor doctor = new Doctor();

        doctor.setId( citaDTO.getDoctorId() );

        return doctor;
    }
}

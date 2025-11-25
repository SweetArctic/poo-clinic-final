package com.clinica.proyecto.application.mapper;

import com.clinica.proyecto.application.dto.PacienteDTO;
import com.clinica.proyecto.infraestructure.modelo.Paciente;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-24T23:39:04-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251118-1623, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class PacienteMapperImpl implements PacienteMapper {

    @Override
    public PacienteDTO toDTO(Paciente paciente) {
        if ( paciente == null ) {
            return null;
        }

        PacienteDTO pacienteDTO = new PacienteDTO();

        pacienteDTO.setId( paciente.getId() );
        pacienteDTO.setNombre( paciente.getNombre() );
        pacienteDTO.setEmail( paciente.getEmail() );
        pacienteDTO.setTelefono( paciente.getTelefono() );
        pacienteDTO.setFechaNacimiento( paciente.getFechaNacimiento() );

        return pacienteDTO;
    }

    @Override
    public Paciente toEntity(PacienteDTO pacienteDTO) {
        if ( pacienteDTO == null ) {
            return null;
        }

        Paciente paciente = new Paciente();

        paciente.setId( pacienteDTO.getId() );
        paciente.setNombre( pacienteDTO.getNombre() );
        paciente.setEmail( pacienteDTO.getEmail() );
        paciente.setTelefono( pacienteDTO.getTelefono() );
        paciente.setFechaNacimiento( pacienteDTO.getFechaNacimiento() );

        return paciente;
    }
}

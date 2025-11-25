package com.clinica.proyecto.application.mapper;

import com.clinica.proyecto.application.dto.HistoriaClinicaDTO;
import com.clinica.proyecto.application.dto.TratamientoDTO;
import com.clinica.proyecto.infraestructure.modelo.HistoriaClinica;
import com.clinica.proyecto.infraestructure.modelo.Paciente;
import com.clinica.proyecto.infraestructure.modelo.Tratamiento;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-25T00:26:44-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Oracle Corporation)"
)
@Component
public class HistoriaClinicaMapperImpl implements HistoriaClinicaMapper {

    @Autowired
    private TratamientoMapper tratamientoMapper;

    @Override
    public HistoriaClinicaDTO toDTO(HistoriaClinica historiaClinica) {
        if ( historiaClinica == null ) {
            return null;
        }

        HistoriaClinicaDTO historiaClinicaDTO = new HistoriaClinicaDTO();

        historiaClinicaDTO.setPacienteId( historiaClinicaPacienteId( historiaClinica ) );
        historiaClinicaDTO.setId( historiaClinica.getId() );
        historiaClinicaDTO.setTratamientos( tratamientoListToTratamientoDTOList( historiaClinica.getTratamientos() ) );

        return historiaClinicaDTO;
    }

    @Override
    public HistoriaClinica toEntity(HistoriaClinicaDTO historiaClinicaDTO) {
        if ( historiaClinicaDTO == null ) {
            return null;
        }

        HistoriaClinica historiaClinica = new HistoriaClinica();

        historiaClinica.setPaciente( historiaClinicaDTOToPaciente( historiaClinicaDTO ) );
        historiaClinica.setId( historiaClinicaDTO.getId() );
        historiaClinica.setTratamientos( tratamientoDTOListToTratamientoList( historiaClinicaDTO.getTratamientos() ) );

        return historiaClinica;
    }

    private Long historiaClinicaPacienteId(HistoriaClinica historiaClinica) {
        if ( historiaClinica == null ) {
            return null;
        }
        Paciente paciente = historiaClinica.getPaciente();
        if ( paciente == null ) {
            return null;
        }
        Long id = paciente.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected List<TratamientoDTO> tratamientoListToTratamientoDTOList(List<Tratamiento> list) {
        if ( list == null ) {
            return null;
        }

        List<TratamientoDTO> list1 = new ArrayList<TratamientoDTO>( list.size() );
        for ( Tratamiento tratamiento : list ) {
            list1.add( tratamientoMapper.toDTO( tratamiento ) );
        }

        return list1;
    }

    protected Paciente historiaClinicaDTOToPaciente(HistoriaClinicaDTO historiaClinicaDTO) {
        if ( historiaClinicaDTO == null ) {
            return null;
        }

        Paciente paciente = new Paciente();

        paciente.setId( historiaClinicaDTO.getPacienteId() );

        return paciente;
    }

    protected List<Tratamiento> tratamientoDTOListToTratamientoList(List<TratamientoDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Tratamiento> list1 = new ArrayList<Tratamiento>( list.size() );
        for ( TratamientoDTO tratamientoDTO : list ) {
            list1.add( tratamientoMapper.toEntity( tratamientoDTO ) );
        }

        return list1;
    }
}

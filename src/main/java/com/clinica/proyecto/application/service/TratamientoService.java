package com.clinica.proyecto.application.service;

import com.clinica.proyecto.application.dto.TratamientoDTO;
import com.clinica.proyecto.application.mapper.TratamientoMapper;
import com.clinica.proyecto.application.repository.ITratamientoRepository;
import com.clinica.proyecto.infraestructure.modelo.Tratamiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TratamientoService {
    @Autowired
    private ITratamientoRepository tratamientoRepository;

    @Autowired
    private TratamientoMapper tratamientoMapper;

    public List<TratamientoDTO> listarPorHistoria(Long historiaId) {
        return tratamientoRepository.findByHistoriaClinicaIdDTO(historiaId);
    }

    public Tratamiento crearDesdeDTO(TratamientoDTO dto) {
        return tratamientoRepository.save(tratamientoMapper.toEntity(dto));
    }

    public Optional<TratamientoDTO> buscar(Long id) {
        return tratamientoRepository.findByIdDTO(id);
    }
}


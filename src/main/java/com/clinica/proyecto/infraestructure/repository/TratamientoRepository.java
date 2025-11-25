package com.clinica.proyecto.infraestructure.repository;

import com.clinica.proyecto.application.dto.TratamientoDTO;
import com.clinica.proyecto.application.mapper.TratamientoMapper;
import com.clinica.proyecto.application.repository.ITratamientoRepository;
import com.clinica.proyecto.infraestructure.modelo.Tratamiento;
import com.clinica.proyecto.infraestructure.repository.jpa.TratamientoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TratamientoRepository implements ITratamientoRepository {
    @Autowired
    private TratamientoJpaRepository tratamientoJpaRepository;
    @Autowired
    private TratamientoMapper tratamientoMapper;

    @Override
    public List<Tratamiento> findAll() { return tratamientoJpaRepository.findAll(); }
    @Override
    public Optional<Tratamiento> findById(Long id) { return tratamientoJpaRepository.findById(id); }
    @Override
    public Tratamiento save(Tratamiento tratamiento) { return tratamientoJpaRepository.save(tratamiento); }
    @Override
    public void deleteById(Long id) { tratamientoJpaRepository.deleteById(id); }
    @Override
    public List<Tratamiento> findByHistoriaClinicaId(Long historiaClinicaId) { return tratamientoJpaRepository.findByHistoriaClinica_Id(historiaClinicaId); }

    @Override
    public List<TratamientoDTO> findAllDTO() { return findAll().stream().map(tratamientoMapper::toDTO).toList(); }
    @Override
    public Optional<TratamientoDTO> findByIdDTO(Long id) { return findById(id).map(tratamientoMapper::toDTO); }
    @Override
    public TratamientoDTO saveDTO(TratamientoDTO tratamientoDTO) { return tratamientoMapper.toDTO(save(tratamientoMapper.toEntity(tratamientoDTO))); }
    @Override
    public void deleteByIdDTO(Long id) { deleteById(id); }
    @Override
    public List<TratamientoDTO> findByHistoriaClinicaIdDTO(Long historiaClinicaId) { return findByHistoriaClinicaId(historiaClinicaId).stream().map(tratamientoMapper::toDTO).toList(); }
}


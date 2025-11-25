package com.clinica.proyecto.infraestructure.repository;

import com.clinica.proyecto.application.dto.DoctorDTO;
import com.clinica.proyecto.application.mapper.DoctorMapper;
import com.clinica.proyecto.application.repository.IDoctorRepository;
import com.clinica.proyecto.infraestructure.modelo.Doctor;
import com.clinica.proyecto.infraestructure.repository.jpa.DoctorJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DoctorRepository implements IDoctorRepository {
    @Autowired
    private DoctorJpaRepository doctorJpaRepository;
    @Autowired
    private DoctorMapper doctorMapper;

    @Override
    public List<Doctor> findAll() { return doctorJpaRepository.findAll(); }
    @Override
    public Optional<Doctor> findById(Long id) { return doctorJpaRepository.findById(id); }
    @Override
    public Doctor save(Doctor doctor) { return doctorJpaRepository.save(doctor); }
    @Override
    public void deleteById(Long id) { doctorJpaRepository.deleteById(id); }

    @Override
    public List<DoctorDTO> findAllDTO() { return findAll().stream().map(doctorMapper::toDTO).toList(); }
    @Override
    public Optional<DoctorDTO> findByIdDTO(Long id) { return findById(id).map(doctorMapper::toDTO); }
    @Override
    public DoctorDTO saveDTO(DoctorDTO doctorDTO) { return doctorMapper.toDTO(save(doctorMapper.toEntity(doctorDTO))); }
    @Override
    public void deleteByIdDTO(Long id) { deleteById(id); }
}


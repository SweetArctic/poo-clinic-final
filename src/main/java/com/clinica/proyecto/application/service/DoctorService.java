package com.clinica.proyecto.application.service;

import com.clinica.proyecto.application.dto.DoctorDTO;
import com.clinica.proyecto.application.mapper.DoctorMapper;
import com.clinica.proyecto.application.repository.IDoctorRepository;
import com.clinica.proyecto.infraestructure.modelo.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private IDoctorRepository doctorRepository;

    @Autowired
    private DoctorMapper doctorMapper;

    public List<DoctorDTO> listar() { return doctorRepository.findAllDTO(); }
    public Optional<DoctorDTO> buscar(Long id) { return doctorRepository.findByIdDTO(id); }
    public Doctor crearDesdeDTO(DoctorDTO dto) { return doctorRepository.save(doctorMapper.toEntity(dto)); }
    public Optional<Doctor> actualizarDesdeDTO(Long id, DoctorDTO dto) {
        return doctorRepository.findById(id).map(d -> {
            d.setNombre(dto.getNombre());
            d.setEspecialidad(dto.getEspecialidad());
            d.setEmail(dto.getEmail());
            d.setTelefono(dto.getTelefono());
            return doctorRepository.save(d);
        });
    }
    public boolean eliminar(Long id) {
        Optional<Doctor> d = doctorRepository.findById(id);
        if (d.isPresent()) { doctorRepository.deleteById(id); return true; }
        return false;
    }
}


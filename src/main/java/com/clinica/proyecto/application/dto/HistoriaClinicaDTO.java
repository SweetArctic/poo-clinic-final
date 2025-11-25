package com.clinica.proyecto.application.dto;

import java.util.List;

public class HistoriaClinicaDTO {
    private Long id;
    private Long pacienteId;
    private List<TratamientoDTO> tratamientos;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getPacienteId() { return pacienteId; }
    public void setPacienteId(Long pacienteId) { this.pacienteId = pacienteId; }
    public List<TratamientoDTO> getTratamientos() { return tratamientos; }
    public void setTratamientos(List<TratamientoDTO> tratamientos) { this.tratamientos = tratamientos; }
}


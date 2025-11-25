package com.clinica.proyecto.application.dto;

import java.time.LocalDate;

public class TratamientoDTO {
    private Long id;
    private Long historiaClinicaId;
    private String descripcion;
    private LocalDate fecha;
    private Long doctorId;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getHistoriaClinicaId() { return historiaClinicaId; }
    public void setHistoriaClinicaId(Long historiaClinicaId) { this.historiaClinicaId = historiaClinicaId; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public Long getDoctorId() { return doctorId; }
    public void setDoctorId(Long doctorId) { this.doctorId = doctorId; }
}


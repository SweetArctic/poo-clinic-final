package com.clinica.proyecto.infraestructure.repository.jpa;

import com.clinica.proyecto.infraestructure.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioJpaRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}


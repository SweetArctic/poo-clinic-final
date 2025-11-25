package com.clinica.proyecto;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.clinica.proyecto.infraestructure.modelo.Usuario;
import com.clinica.proyecto.infraestructure.modelo.enums.RolUsuario;
import com.clinica.proyecto.infraestructure.repository.jpa.UsuarioJpaRepository;

@SpringBootApplication
public class ProyectoClinicaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProyectoClinicaApplication.class, args);
    }

    @Bean
    CommandLineRunner bootstrapAdmin(UsuarioJpaRepository usuarioRepo, PasswordEncoder encoder) {
        return args -> {
            usuarioRepo.findByUsername("admin").orElseGet(() -> {
                Usuario u = new Usuario();
                u.setUsername("admin");
                u.setPassword(encoder.encode("admin123"));
                u.setRol(RolUsuario.ADMIN);
                u.setEnabled(true);
                return usuarioRepo.save(u);
            });
        };
    }
}

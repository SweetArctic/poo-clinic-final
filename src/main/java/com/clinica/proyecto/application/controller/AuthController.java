package com.clinica.proyecto.application.controller;

import com.clinica.proyecto.application.dto.UsuarioDTO;
import com.clinica.proyecto.application.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registro")
    public ResponseEntity<UsuarioDTO> registrar(@RequestBody UsuarioDTO body) {
        UsuarioDTO creado = usuarioService.registrar(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }
}


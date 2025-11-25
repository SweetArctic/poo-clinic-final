package com.clinica.proyecto.config;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> badRequest(HttpMessageNotReadableException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "invalid_json"));
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<Map<String, String>> dataError(DataAccessException ex) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(Map.of("error", "database_error"));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> generic(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "request_failed"));
    }
}

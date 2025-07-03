package com.example.triagem.controller;

import com.example.triagem.model.Paciente;
import com.example.triagem.service.AtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api") // Define um prefixo para todos os endpoints deste controller
public class TriagemController {

    @Autowired
    private AtendimentoService atendimentoService;

    // Endpoint para registrar a triagem de um novo paciente
    @PostMapping("/triagem")
    public ResponseEntity<Paciente> realizarTriagem(@RequestBody Paciente paciente) {
        Paciente novoPaciente = atendimentoService.registrarTriagem(paciente);
        // Retorna o paciente criado com o status HTTP 201
        return new ResponseEntity<>(novoPaciente, HttpStatus.CREATED);
    }

    // Endpoint para buscar um paciente específico.
    @GetMapping("/pacientes/{id}")
    public ResponseEntity<Paciente> buscarPaciente(@PathVariable Long id) {
        Optional<Paciente> paciente = atendimentoService.buscarPacientePorId(id);

        // Se o paciente foi encontrado, retorna com status 200 
        if (paciente.isPresent()) {
            return ResponseEntity.ok(paciente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

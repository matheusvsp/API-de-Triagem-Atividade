package com.example.triagem.controller;

import com.example.triagem.model.Paciente;
import com.example.triagem.service.AtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AtendimentoController {

    @Autowired
    private AtendimentoService atendimentoService;
    
    // GET /api/atendimento/proximo
    @GetMapping("/atendimento/proximo")
    public ResponseEntity<?> getProximoPaciente() {
        try {
            Paciente proximo = atendimentoService.proximoParaAtendimento();
            if (proximo != null) {
                // Se encontrou um paciente, remove ele da fila (simulação simples)
                
                return ResponseEntity.ok(proximo);
            } else {
                // Se não há pacientes na fila
                Map<String, String> response = new HashMap<>();
                response.put("message", "Não há pacientes aguardando atendimento.");
                return ResponseEntity.ok(response);
            }
        } catch (RuntimeException e) {
            // Captura a exceção de "nenhum médico em plantão"
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.SERVICE_UNAVAILABLE); // HTTP 503
        }
    }
}

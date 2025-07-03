package com.example.triagem.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController 
public class HealthController {

    // Mapeia requisições GET para o caminho /health
    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> checkHealth() {
        // Cria um mapa simples para a resposta JSON
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");
        response.put("message", "Sistema no ar!");
        
        return ResponseEntity.ok(response);
    }
}

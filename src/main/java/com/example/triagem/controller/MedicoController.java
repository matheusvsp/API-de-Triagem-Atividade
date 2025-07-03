package com.example.triagem.controller;

import com.example.triagem.model.Medico;
import com.example.triagem.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    // Endpoint para cadastrar um novo médico
    @PostMapping("/medicos")
    public ResponseEntity<Medico> cadastrarMedico(@RequestBody Medico medico) {
        // Garante que o médico novo começa fora de plantão
        medico.setEmPlantao(false); 
        Medico novoMedico = medicoService.cadastrarMedico(medico);
        return new ResponseEntity<>(novoMedico, HttpStatus.CREATED);
    }

    // Endpoint para atualizar o status de plantão de um médico
    @PutMapping("/medicos/{id}/plantao")
    public ResponseEntity<Medico> atualizarPlantao(@PathVariable Long id, @RequestBody Map<String, Boolean> body) {
        Boolean emPlantao = body.get("emPlantao");

        // Validação simples da requisição
        if (emPlantao == null) {
            return ResponseEntity.badRequest().build();
        }

        Medico medicoAtualizado = medicoService.atualizarPlantao(id, emPlantao);

        if (medicoAtualizado != null) {
            return ResponseEntity.ok(medicoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

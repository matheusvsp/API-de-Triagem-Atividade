package com.example.triagem.repository;

import com.example.triagem.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Indica que esta é uma classe de acesso a dados.
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    
    // Query customizada para buscar o próximo paciente
    // A ordem é: Prioridade (VERMELHA > AMARELA > VERDE) e depois Gravidade (GRAVE > MODERADA > LEVE)
    @Query("SELECT p FROM Paciente p ORDER BY " +
           "CASE p.prioridade " +
           "WHEN 'VERMELHA' THEN 1 " +
           "WHEN 'AMARELA' THEN 2 " +
           "WHEN 'VERDE' THEN 3 " +
           "ELSE 4 END, " +
           "CASE p.gravidade " +
           "WHEN 'GRAVE' THEN 1 " +
           "WHEN 'MODERADA' THEN 2 " +
           "WHEN 'LEVE' THEN 3 " +
           "ELSE 4 END")
    List<Paciente> findProximoPacienteParaAtendimento();
}

package com.example.triagem.repository;

import com.example.triagem.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    // O Spring Data JPA cria a query automaticamente pelo nome do método
    // Este método contará quantos médicos estão com 'emPlantao' = true
    long countByEmPlantao(boolean emPlantao);
}

package com.example.triagem.service;

import com.example.triagem.model.Medico;
import com.example.triagem.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service // Indica que é uma classe de serviço
public class MedicoService {

    @Autowired // Injeta a dependência do repositório automaticamente
    private MedicoRepository medicoRepository;

    // Método para cadastrar um novo médico.
    public Medico cadastrarMedico(Medico medico) {
        // Simplesmente salva o objeto médico no banco de dados
        return medicoRepository.save(medico);
    }

    // Método para atualizar o status de plantão
    public Medico atualizarPlantao(Long id, boolean emPlantao) {
        // Procura o médico pelo ID
        Optional<Medico> medicoOptional = medicoRepository.findById(id);

        // Se não encontrar, retorna null
        if (medicoOptional.isEmpty()) {
            return null;
        }

        // Se encontrou, atualiza o status e salva
        Medico medico = medicoOptional.get();
        medico.setEmPlantao(emPlantao);
        return medicoRepository.save(medico);
    }
}

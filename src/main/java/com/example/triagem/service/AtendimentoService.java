package com.example.triagem.service;

import com.example.triagem.model.Paciente;
import com.example.triagem.repository.MedicoRepository;
import com.example.triagem.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtendimentoService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    // Método para registrar a chegada de um paciente (triagem)
    public Paciente registrarTriagem(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    // Método para buscar um paciente pelo seu propio ID
    public Optional<Paciente> buscarPacientePorId(Long id) {
        return pacienteRepository.findById(id);
    }

    // Lógica para encontrar o próximo paciente a ser atendido
    public Paciente proximoParaAtendimento() {
        //Verifica se há médicos em plantão.
        long medicosEmPlantao = medicoRepository.countByEmPlantao(true);
        if (medicosEmPlantao == 0) {
            // Lança uma exceção se não houver médicos o Controller vai ser responssavel por isso
            throw new RuntimeException("Nenhum médico em plantão para realizar o atendimento.");
        }

        //Busca a lista de pacientes ordenada por prioridade e gravidade
        List<Paciente> pacientesOrdenados = pacienteRepository.findProximoPacienteParaAtendimento();

        //Se a lista não estiver vazia, retorna o primeiro (o mais urgente)
        if (!pacientesOrdenados.isEmpty()) {
            return pacientesOrdenados.get(0);
        }

        // 4. Se não houver pacientes, retorna null / vazio
        return null;
    }
}

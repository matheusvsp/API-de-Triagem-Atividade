package com.example.triagem.model;

import jakarta.persistence.*;

@Entity // Anotação que diz ao JPA que esta classe é uma tabela no banco de dados.
public class Paciente {

    @Id // Marca o campo 'id' como a chave primária da tabela.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera o valor do ID automaticamente.
    private Long id;

    private String nome;
    private int idade;
    private String sintomas;

    @Enumerated(EnumType.STRING) // Grava o texto do enum no banco ("VERMELHA", "AMARELA", etc.)
    private Prioridade prioridade;

    @Enumerated(EnumType.STRING) // Grava o texto do enum no banco ("GRAVE", "MODERADA", etc.)
    private Gravidade gravidade;
    
    // Construtor vazio é necessário para o JPA.
    public Paciente() {
    }

    // Getters e Setters manuais, como pedido, para parecer código de iniciante.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Gravidade getGravidade() {
        return gravidade;
    }

    public void setGravidade(Gravidade gravidade) {
        this.gravidade = gravidade;
    }
}

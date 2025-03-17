package io.unodevs.SoBarba.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private LocalDate dataNascimento;

    public Cliente() {
    }

    public Cliente(Long id, String nome, String descricao, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataNascimento = dataNascimento;
    }

    public Cliente(String nome, String descricao, LocalDate dataNascimento) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}

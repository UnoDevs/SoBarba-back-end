package io.unodevs.SoBarba.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private double valor;

    private int tempo;

    private String descricao;

    private boolean status;

    public Service() {
    }

    public Service(Long id, String nome, double valor, int tempo, String descricao, boolean status) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.tempo = tempo;
        this.descricao = descricao;
        this.status = status;
    }

    public Service(String nome, double valor, int tempo, String descricao, boolean status) {
        this.nome = nome;
        this.valor = valor;
        this.tempo = tempo;
        this.descricao = descricao;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public int getTempo() {
        return tempo;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

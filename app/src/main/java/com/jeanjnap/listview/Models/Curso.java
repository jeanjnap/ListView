package com.jeanjnap.listview.Models;

public class Curso {

    private String nome;
    private String descricao;
    private EstadoAtual estado;

    public Curso() {
    }

    public Curso(String nome, String descricao, EstadoAtual estado) {
        this.nome = nome;
        this.descricao = descricao;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return nome;
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

    public EstadoAtual getEstado() {
        return estado;
    }

    public void setEstado(EstadoAtual estado) {
        this.estado = estado;
    }

    public enum EstadoAtual {

        FAZENDO {
            @Override
            public String toString() {
                return "Fazendo";
            }
        }, FINALIZADO {
            @Override
            public String toString() {
                return "finalizado";
            }
        };
    }
}



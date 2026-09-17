package br.com.prothera.teste.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class Pessoa {
    private String nome;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}

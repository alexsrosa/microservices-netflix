package com.fundacred.universidadeservice.infrastruture.dto;

import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
public class EstudanteDto implements Serializable {

    private static final long serialVersionUID = 4585152307796895312L;

    private String id;
    private String nome;
    private String cpf;
    private String email;
    private String universidade;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUniversidade() {
        return universidade;
    }

    public void setUniversidade(String universidade) {
        this.universidade = universidade;
    }

    @Override
    public String toString() {
        return "Estudante{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", universidade='" + universidade + '\'' +
                '}';
    }
}

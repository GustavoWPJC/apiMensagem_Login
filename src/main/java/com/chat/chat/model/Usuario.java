package com.chat.chat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;
    private int crp;
    private String tipo; // PSICOLOGO ou SUPERVISOR

    public Usuario() {}

    public Usuario(String nome, String email, String senha, int crp, String tipo) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.crp = crp;
        this.tipo = tipo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getCrp() {
        return crp;
    }

    public void setCrp(int crp) {
        this.crp = crp;
    }

    public String getTipoUsuario() {
        return tipo;
    }

    public void setTipoUsuario(String tipo) {
        this.tipo = tipo;
    }
}
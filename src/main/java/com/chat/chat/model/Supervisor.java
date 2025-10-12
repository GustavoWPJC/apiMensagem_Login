package com.chat.chat.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Supervisor")
public class Supervisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_supervisor")
    private Integer id;

    private String nome;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "foto_perfil")
    private String fotoPerfil;

    @Column(name = "area_atuacao")
    private String areaAtuacao;

    private String email;
    private String telefone;
    private String crp;

    @Column(name = "data_disponibilidade")
    private LocalDate dataDisponibilidade;

    private String senha;
    private String bio;
    private String comentarios;
    private Double nota;
    private String cidade;
    private String uf;

    // getters e setters
    public Supervisor() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getFotoPerfil() { return fotoPerfil; }
    public void setFotoPerfil(String fotoPerfil) { this.fotoPerfil = fotoPerfil; }

    public String getAreaAtuacao() { return areaAtuacao; }
    public void setAreaAtuacao(String areaAtuacao) { this.areaAtuacao = areaAtuacao; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getCrp() { return crp; }
    public void setCrp(String crp) { this.crp = crp; }

    public LocalDate getDataDisponibilidade() { return dataDisponibilidade; }
    public void setDataDisponibilidade(LocalDate dataDisponibilidade) { this.dataDisponibilidade = dataDisponibilidade; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }

    public String getComentarios() { return comentarios; }
    public void setComentarios(String comentarios) { this.comentarios = comentarios; }

    public Double getNota() { return nota; }
    public void setNota(Double nota) { this.nota = nota; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getUf() { return uf; }
    public void setUf(String uf) { this.uf = uf; }
}

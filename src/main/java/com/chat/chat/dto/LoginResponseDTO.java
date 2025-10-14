package com.chat.chat.dto;

public class LoginResponseDTO {
    private Integer id;
    private String nome;
    private String tipoUsuario;

    public LoginResponseDTO(Integer id, String nome, String tipoUsuario) {
        this.id = id;
        this.nome = nome;
        this.tipoUsuario = tipoUsuario;
    }

    public Integer getId() { return id; }
    public String getNome() { return nome; }
    public String getTipoUsuario() { return tipoUsuario; }
}

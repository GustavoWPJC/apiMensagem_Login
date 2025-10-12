package com.chat.chat.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Solicitacao")
public class Solicitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitacao")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_psicologo", referencedColumnName = "id_psicologo", nullable = false)
    private Psicologo psicologo;

    @ManyToOne
    @JoinColumn(name = "id_supervisor", referencedColumnName = "id_supervisor", nullable = false)
    private Supervisor supervisor;

    private String mensagem;
    private String status;

    @Column(name = "data_solicitacao")
    private LocalDateTime dataSolicitacao;

    public Solicitacao() {
        this.status = "pendente";
        this.dataSolicitacao = LocalDateTime.now();
    }

    // getters / setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Psicologo getPsicologo() { return psicologo; }
    public void setPsicologo(Psicologo psicologo) { this.psicologo = psicologo; }

    public Supervisor getSupervisor() { return supervisor; }
    public void setSupervisor(Supervisor supervisor) { this.supervisor = supervisor; }

    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getDataSolicitacao() { return dataSolicitacao; }
    public void setDataSolicitacao(LocalDateTime dataSolicitacao) { this.dataSolicitacao = dataSolicitacao; }
}

package com.chat.chat.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consulta")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_psicologo", referencedColumnName = "id_psicologo", nullable = false)
    private Psicologo psicologo;

    @ManyToOne
    @JoinColumn(name = "id_supervisor", referencedColumnName = "id_supervisor", nullable = false)
    private Supervisor supervisor;

    @Column(name = "data_consulta")
    private LocalDate dataConsulta;

    // getters/setters
    public Consulta() {}
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Psicologo getPsicologo() { return psicologo; }
    public void setPsicologo(Psicologo psicologo) { this.psicologo = psicologo; }

    public Supervisor getSupervisor() { return supervisor; }
    public void setSupervisor(Supervisor supervisor) { this.supervisor = supervisor; }

    public LocalDate getDataConsulta() { return dataConsulta; }
    public void setDataConsulta(LocalDate dataConsulta) { this.dataConsulta = dataConsulta; }
}

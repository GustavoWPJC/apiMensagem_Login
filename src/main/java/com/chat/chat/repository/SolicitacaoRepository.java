package com.chat.chat.repository;

import com.chat.chat.model.Solicitacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {

    List<Solicitacao> findBySupervisorId(Long supervisorId);

    List<Solicitacao> findByPsicologoId(Long psicologoId);
}
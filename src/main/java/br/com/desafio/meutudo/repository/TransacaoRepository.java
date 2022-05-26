package br.com.desafio.meutudo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.meutudo.Entity.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long>{

}

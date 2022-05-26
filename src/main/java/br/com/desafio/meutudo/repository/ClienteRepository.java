package br.com.desafio.meutudo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.meutudo.Entity.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}

//Repositorio onde faz todas as buscas necessárias.
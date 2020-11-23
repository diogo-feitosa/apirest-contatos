package com.contatos.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contatos.apirest.models.Contatos;

public interface ContatosRepository extends JpaRepository<Contatos, Long> {
	Contatos findById(long id);
}

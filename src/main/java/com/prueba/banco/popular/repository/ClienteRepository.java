package com.prueba.banco.popular.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.banco.popular.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	Cliente findByDocumento(Integer documento);

}

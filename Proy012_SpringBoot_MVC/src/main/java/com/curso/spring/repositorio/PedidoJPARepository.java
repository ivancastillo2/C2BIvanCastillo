package com.curso.spring.repositorio;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.spring.entidades.Pedido;

@Repository
public interface PedidoJPARepository extends JpaRepository<Pedido, Integer> {

	public static Logger Log = LoggerFactory.getLogger(PedidoJPARepository.class);
	
	public List<Pedido> findByUser(String user);
}

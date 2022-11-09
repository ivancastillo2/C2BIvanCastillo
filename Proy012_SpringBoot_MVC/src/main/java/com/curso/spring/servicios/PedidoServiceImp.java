package com.curso.spring.servicios;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.curso.spring.entidades.Pedido;
import com.curso.spring.excepciones.PedidosException;
import com.curso.spring.repositorio.PedidoJPARepository;
import com.curso.spring.repositorio.PedidoRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PedidoServiceImp implements PedidosService {

	private static Logger log = LoggerFactory.getLogger(PedidoServiceImp.class);
	
//	@Autowired
//	@Qualifier("pedidoRepo")
//	private PedidoRepository repo;
	
	@Autowired
	private PedidoJPARepository repo;
	
	public PedidoServiceImp() {
		log.info("--- instanciando PedidoServiceImp " + repo);
	}
	
	@PostConstruct
	public void init() {
		log.info("... postconruct " + repo);

	}
	
	@Override
	public Pedido generarPedido(Pedido p) {
		log.info("gestiono un pedido");
//		repo.add(p);
		return repo.save(p);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Pedido> getPedidos(String user) {
//		return (user == null)
//				? repo.getAll()
//				: repo.getPedidosByUser(user);
		return (user == null)
				? repo.findAll()
				: repo.findByUser(user);
	}

	@Override
	public Optional<Pedido> getPedido(Integer id) {
		return repo.findById(id);
	}

	@Override
	public void borrarPedido(Integer id) throws PedidosException {
		if(!repo.existsById(id)) {
			throw new PedidosException("El pedido no se puedo borrar. No existe el pedido con el id " + id);
		}
		repo.deleteById(id);		
	}

	@Override
	public Pedido modificar(Pedido p) {
		repo.save(p);
		return p;
	}
	
}

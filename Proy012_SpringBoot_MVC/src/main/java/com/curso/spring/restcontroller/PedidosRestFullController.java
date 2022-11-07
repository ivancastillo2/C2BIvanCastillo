package com.curso.spring.restcontroller;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.spring.entidades.Pedido;
import com.curso.spring.servicios.PedidosService;

@RestController
public class PedidosRestFullController {

	@Autowired
	private PedidosService pedidoService;
	
	@GetMapping("/ws/pedidos")
	public Collection<Pedido> all() {
		return pedidoService.getPedidos(null);
	}
	
	@GetMapping("/ws/pedidos/{id}")
	public Pedido conseguirId(@PathVariable Integer id) {
		return pedidoService.getPedido(id).get();
	}
	
	@PostMapping("/ws/pedidos")
	public Pedido insertarProducto(@RequestBody Pedido newPedido) {
		return pedidoService.generarPedido(newPedido);
	}
	
	@PutMapping("/ws/pedidos")
	public Pedido update(@RequestBody Pedido pedidoAModificar) {
		Pedido pModif = pedidoService.modificar(pedidoAModificar);
		return pModif;
	}
	
	@DeleteMapping("/ws/pedidos/{id}")
	public void deleteById(@PathVariable Integer id) {
		pedidoService.borrarPedido(id);
	}
}

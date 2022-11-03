package com.curso.spring.controller;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.curso.spring.entidades.Pedido;
import com.curso.spring.entidades.Usuario;
import com.curso.spring.servicios.PedidosService;

@Controller
@SessionAttributes("usuario")
public class PedidosController {

	@Autowired
	private PedidosService pedidoService;
	
	@GetMapping("/pedidos")
	public String pedidos(Model model) {
		Collection<Pedido> lista = conseguirLista(model);
		model.addAttribute("listaPedidos", lista);
		model.addAttribute("pedidoForm", new Pedido());
		return "pedidos";
	}
	
//	@GetMapping("/pedidos/{userName}")
//	public String pedidosCliente(Model model,
//						@PathVariable("userName") String name) {
//		Collection<Pedido> lista = pedidoService.getPedidos(name);
//		model.addAttribute("listaPedidos", lista);
//		model.addAttribute("pedidoForm", new Pedido());
//		return "pedidos";
//	}
	
	@GetMapping(value={"/pedido", "/pedidos/pedido"})
	public String verDetallesProducto(Model model,
						@RequestParam("idPedido") Optional<Integer> id) {
		Integer idPedido = id.orElse(null);
		if(id.isEmpty()) {
			return "redirect:/pedidos";
		}
		model.addAttribute("pedido", pedidoService.getPedido(idPedido));
		return "detalle-pedido";
	}
	
	@PostMapping(value={"/altaProducto", "/pedidos/altaProducto"})
	public String altaProducto(Model model,
				@ModelAttribute("pedidoForm") @Valid Pedido p,
				BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			Collection<Pedido> lista = conseguirLista(model);
			model.addAttribute("listaPedidos", lista);
			return "pedidos";
		}
		
		Usuario u = (Usuario) model.getAttribute("usuario");
		p.setUser(u.getNombre());
		p.setFechaPedido(new Date());
		pedidoService.generarPedido(p);
		
		return "redirect:/pedidos";
	}
	
	@GetMapping(value= {"/borrar", "/pedidos/borrar"})
	public String borrarProducto(Model model,
					@RequestParam("idPedido") Optional<Integer> id) {
		Integer idPedido = id.orElse(null);
		if(id.isEmpty()) {
			return "redirect:/pedidos";
		}
		pedidoService.borrarPedido(idPedido);
		
		Usuario u = (Usuario) model.getAttribute("usuario");
		return (u.getRol().equals("cliente"))
				? "redirect:/pedidos/" + u.getNombre()
				: "redirect:/pedidos";
	}
	
	private Collection<Pedido> conseguirLista(Model model) {
		Usuario u = (Usuario) model.getAttribute("usuario");
		Collection<Pedido> lista = (u.getRol().equals("admin"))
				? pedidoService.getPedidos(null)
				: pedidoService.getPedidos(u.getNombre());
		return lista;
	}
}

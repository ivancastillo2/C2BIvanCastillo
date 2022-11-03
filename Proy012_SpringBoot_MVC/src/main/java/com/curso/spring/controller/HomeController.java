package com.curso.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.curso.spring.entidades.Usuario;

@Controller
@SessionAttributes("usuario")
public class HomeController {

	@GetMapping("/")
	public String inicio(Model model) {
			if(model.getAttribute("usuario") == null) {
				return "redirect:/login";
			}
			return "home";
	}
	
}

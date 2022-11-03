package com.curso.spring.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.curso.spring.entidades.Usuario;

@Controller
@SessionAttributes("usuario")
public class LoginController {

	//@AutoWired
	//private LoginService loginService;
	
	@GetMapping("/login")
	public String loginPage(Model model) {
		model.addAttribute("usuarioForm", new Usuario());
		return "login";
	}
	
	@PostMapping("/login")
	public String irAHome(Model model, 
			@ModelAttribute("usuarioForm") @Valid Usuario usr,
			BindingResult bindingResult) {
		//if(loginService.validarLog(nombre, clave))
		if(bindingResult.hasErrors()) {
			return "login";
		}
		
		if(usr.getNombre().trim().equalsIgnoreCase("LUIS")) {
			usr.setRol("cliente");
		} else {
			usr.setRol("admin");
		}
		model.addAttribute("usuario", usr);
		return "home";
		//else
		//return "login";
	}
	
}

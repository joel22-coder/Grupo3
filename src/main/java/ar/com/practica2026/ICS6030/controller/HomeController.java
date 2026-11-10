package ar.com.practica2026.ICS6030.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String mostrarInicio() {
		return "index";
	}

}
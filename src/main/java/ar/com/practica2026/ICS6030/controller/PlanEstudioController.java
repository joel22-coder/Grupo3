package ar.com.practica2026.ICS6030.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.com.practica2026.ICS6030.entity.PlanEstudio;
import ar.com.practica2026.ICS6030.service.CarreraService;        
import ar.com.practica2026.ICS6030.service.PlanEstudioService;

@Controller
@RequestMapping("/planes")
public class PlanEstudioController {

	private final PlanEstudioService planEstudioService;
	private final CarreraService carreraService;                   

	public PlanEstudioController(PlanEstudioService planEstudioService,
			CarreraService carreraService) {              
		this.planEstudioService = planEstudioService;
		this.carreraService = carreraService;                      
	}

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("planes", planEstudioService.listarTodos());
		return "planes/listPlanes";
	}

	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("plan", new PlanEstudio());
		model.addAttribute("carreras", carreraService.listarTodas());  
		return "planes/formPlan";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		model.addAttribute("plan", planEstudioService.buscarPorId(id));
		model.addAttribute("carreras", carreraService.listarTodas()); 
		return "planes/formPlan";
	}

	@PostMapping("/guardar")
	public String guardar(PlanEstudio plan) {
		planEstudioService.guardar(plan);
		return "redirect:/planes";
	}

	@PostMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		planEstudioService.eliminar(id);
		return "redirect:/planes";
	}

}
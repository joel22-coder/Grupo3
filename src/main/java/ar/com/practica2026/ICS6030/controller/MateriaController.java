package ar.com.practica2026.ICS6030.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.com.practica2026.ICS6030.entity.Materia;
import ar.com.practica2026.ICS6030.service.MateriaService;
import ar.com.practica2026.ICS6030.service.PlanEstudioService;

@Controller
@RequestMapping("/materias")
public class MateriaController {

	private final MateriaService materiaService;
	private final PlanEstudioService planEstudioService;

	public MateriaController(MateriaService materiaService, PlanEstudioService planEstudioService) {
		this.materiaService = materiaService;
		this.planEstudioService = planEstudioService;
	}

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("materias", materiaService.listarTodas());
		return "materias/listMaterias";
	}

	@GetMapping("/nueva")
	public String nueva(Model model) {
		model.addAttribute("materia", new Materia());
		model.addAttribute("planes", planEstudioService.listarTodos());
		return "materias/formMateria";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		model.addAttribute("materia", materiaService.buscarPorId(id));
		model.addAttribute("planes", planEstudioService.listarTodos());
		return "materias/formMateria";
	}

	@PostMapping("/guardar")
	public String guardar(Materia materia) {
		materiaService.guardar(materia);
		return "redirect:/materias";
	}

	@PostMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		materiaService.eliminar(id);
		return "redirect:/materias";
	}
}
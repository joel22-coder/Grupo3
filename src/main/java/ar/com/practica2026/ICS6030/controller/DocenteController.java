package ar.com.practica2026.ICS6030.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ar.com.practica2026.ICS6030.entity.Docente;
import ar.com.practica2026.ICS6030.service.DocenteService;

@Controller
@RequestMapping("/docentes")
public class DocenteController {

	private final DocenteService docenteService;

	public DocenteController(DocenteService docenteService) {
		super();
		this.docenteService = docenteService;
	}

	@GetMapping
	public String listar(@RequestParam(name = "buscar", required = false) String buscar, Model model) {
		model.addAttribute("docentes", docenteService.buscar(buscar));
		model.addAttribute("buscar", buscar);
		return "docentes/listDocentes";
	}

	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("docente", new Docente());
		return "docentes/formDocente";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		model.addAttribute("docente", docenteService.buscarPorId(id));
		return "docentes/formDocente";
	}

	@PostMapping("/guardar")
	public String guardar(Docente docente, Model model) {
		// Diccionario: el DNI no puede repetirse entre docentes
		if (docenteService.existeOtroConDni(docente)) {
			model.addAttribute("error", "Ya hay un docente cargado con el DNI " + docente.getDni() + ".");
			return "docentes/formDocente";
		}
		docenteService.guardar(docente);
		return "redirect:/docentes";
	}

	@PostMapping("/baja/{id}")
	public String darDeBaja(@PathVariable("id") Long id) {
		docenteService.cambiarEstado(id, "Inactivo");
		return "redirect:/docentes";
	}

	@PostMapping("/reactivar/{id}")
	public String reactivar(@PathVariable("id") Long id) {
		docenteService.cambiarEstado(id, "Activo");
		return "redirect:/docentes";
	}

}

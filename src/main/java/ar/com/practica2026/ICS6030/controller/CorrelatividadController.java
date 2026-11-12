package ar.com.practica2026.ICS6030.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.com.practica2026.ICS6030.entity.Correlatividad;
import ar.com.practica2026.ICS6030.entity.Materia;
import ar.com.practica2026.ICS6030.service.CorrelatividadService;
import ar.com.practica2026.ICS6030.service.MateriaService;

@Controller
@RequestMapping("/correlativas")
public class CorrelatividadController {

	private final CorrelatividadService correlatividadservice;
	private final MateriaService materiaservice;

	public CorrelatividadController(CorrelatividadService correlatividadservice, MateriaService materiaservice) {
		super();
		this.correlatividadservice = correlatividadservice;
		this.materiaservice = materiaservice;
	}

	@GetMapping("/materia/{id}")
	public String listar(@PathVariable("id") Long id, Model model) {
		Materia materia = materiaservice.buscarPorId(id);
		Correlatividad nueva = new Correlatividad();
		nueva.setMateria(materia);
		model.addAttribute("materia", materia);
		model.addAttribute("correlativas", correlatividadservice.listarPorMateria(materia));
		model.addAttribute("materiasDelPlan", materiaservice.listarPorPlan(materia.getPlanEstudio()));
		model.addAttribute("correlatividad", nueva);
		return "materias/correlativas";

	}

	@PostMapping("/guardar")
	public String guardar(Correlatividad correlatividad) {
		correlatividadservice.guardar(correlatividad);
		return "redirect:/correlativas/materia/" + correlatividad.getMateria().getIdMateria();
	}

	@PostMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		Long idMateria = correlatividadservice.buscarPorId(id).getMateria().getIdMateria();
		correlatividadservice.eliminar(id);
		return "redirect:/correlativas/materia/" + idMateria;
	}

}

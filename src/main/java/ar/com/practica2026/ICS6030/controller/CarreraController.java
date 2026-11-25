package ar.com.practica2026.ICS6030.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.com.practica2026.ICS6030.entity.Carrera;
import ar.com.practica2026.ICS6030.entity.Materia;
import ar.com.practica2026.ICS6030.entity.PlanEstudio;
import ar.com.practica2026.ICS6030.service.CarreraService;
import ar.com.practica2026.ICS6030.service.CorrelatividadService;
import ar.com.practica2026.ICS6030.service.HorarioService;
import ar.com.practica2026.ICS6030.service.MateriaService;
import ar.com.practica2026.ICS6030.service.PlanEstudioService;

@Controller
@RequestMapping("/carreras")
public class CarreraController {

	private final CarreraService carreraService;
	private final MateriaService materiaService;
	private final HorarioService horarioService;

	public CarreraController(CarreraService carreraService, MateriaService materiaService,
			HorarioService horarioService) {
		this.carreraService = carreraService;
		this.materiaService = materiaService;
		this.horarioService = horarioService;
	}

	// Listado: GET /carreras
	@GetMapping
	public String listar(Model model) {
		model.addAttribute("carreras", carreraService.listarTodas());
		return "carreras/listCarreras";
	}

	// Formulario vacío: GET /carreras/nueva
	@GetMapping("/nueva")
	public String nueva(Model model) {
		model.addAttribute("carrera", new Carrera());
		return "carreras/formCarrera";
	}

	// Formulario con datos para modificar: GET /carreras/editar/5
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		model.addAttribute("carrera", carreraService.buscarPorId(id));
		return "carreras/formCarrera";
	}

	// Recibe el formulario: POST /carreras/guardar
	@PostMapping("/guardar")
	public String guardar(Carrera carrera) {
		carreraService.guardar(carrera);
		return "redirect:/carreras";
	}

	// Elimina: POST /carreras/eliminar/5
	@PostMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id, Model model) {
		Carrera carrera = carreraService.buscarPorId(id);
		// junta las materias de todos los planes de la carrera
		List<Materia> materias = new ArrayList<>();
		for (PlanEstudio plan : carrera.getPlanes()) {
			materias.addAll(materiaService.listarPorPlan(plan));
		}
		if (!horarioService.listarPorMaterias(materias).isEmpty()) {
			model.addAttribute("error", "No se puede eliminar la carrera " + carrera.getNombre()
					+ " porque tiene materias con horarios cargados.");
			model.addAttribute("carreras", carreraService.listarTodas());
			return "carreras/listCarreras";
		}
		carreraService.eliminar(id);
		return "redirect:/carreras";
	}

}
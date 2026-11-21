package ar.com.practica2026.ICS6030.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.com.practica2026.ICS6030.entity.Horario;
import ar.com.practica2026.ICS6030.service.DocenteService;
import ar.com.practica2026.ICS6030.service.HorarioService;
import ar.com.practica2026.ICS6030.service.MateriaService;

@Controller
@RequestMapping("/horarios")
public class HorarioController {

	private final HorarioService horarioService;
	private final MateriaService materiaService;
	private final DocenteService docenteService;

	public HorarioController(HorarioService horarioService, MateriaService materiaService,
			DocenteService docenteService) {
		this.horarioService = horarioService;
		this.materiaService = materiaService;
		this.docenteService = docenteService;
	}

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("horarios", horarioService.listarTodos());
		return "horarios/listHorarios";
	}

	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("horario", new Horario());
		model.addAttribute("materias", materiaService.listarTodas());
		model.addAttribute("docentes", docenteService.listarActivos());
		return "horarios/formHorario";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		model.addAttribute("horario", horarioService.buscarPorId(id));
		model.addAttribute("materias", materiaService.listarTodas());
		model.addAttribute("docentes", docenteService.listarActivos());
		return "horarios/formHorario";
	}

	@PostMapping("/guardar")
	public String guardar(Horario horario, Model model) {
		// Regla del diccionario: hora_fin debe ser posterior a hora_inicio
		if (!horario.getHoraFin().isAfter(horario.getHoraInicio())) {
			model.addAttribute("error", "La hora de fin debe ser posterior a la hora de inicio.");
			model.addAttribute("materias", materiaService.listarTodas());
			model.addAttribute("docentes", docenteService.listarActivos());
			return "horarios/formHorario";
		}
		horarioService.guardar(horario);
		return "redirect:/horarios";
	}

	@PostMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		horarioService.eliminar(id);
		return "redirect:/horarios";
	}
}
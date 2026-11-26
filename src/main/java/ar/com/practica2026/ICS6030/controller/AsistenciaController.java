package ar.com.practica2026.ICS6030.controller;


	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.servlet.mvc.support.RedirectAttributes;

	import ar.com.practica2026.ICS6030.entity.Asistencia;
	import ar.com.practica2026.ICS6030.entity.Docente;
	import ar.com.practica2026.ICS6030.repository.DocenteRepository;
	import ar.com.practica2026.ICS6030.service.asistenciaservice;


@Controller
@RequestMapping("/asistencias")
public class AsistenciaController {

    @Autowired
    private final asistenciaservice asistenciaservice;

    @Autowired
    private final DocenteRepository docenteRepository;

    public AsistenciaController(asistenciaservice asistenciaService,
            DocenteRepository docenteRepository) {

        this.asistenciaservice = asistenciaService;
        this.docenteRepository = docenteRepository;
    }

    // Listado: asistencias
    @GetMapping
    public String listar(Model model) {

        model.addAttribute("asistencias",
                asistenciaservice.listarTodas());

        return "asistencia/listAsistencia";
    }

    // Formulario vacío: 
    @GetMapping("/nueva")
    public String nueva(Model model) {

        model.addAttribute("asistencia", new Asistencia());

        cargarDocentesActivos(model);

        return "asistencia/formAsistencia";
    }

    // Formulario para modificar
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {

        model.addAttribute("asistencia",
                asistenciaservice.buscarPorId(id));

        cargarDocentesActivos(model);

        return "asistencia/formAsistencia";
    }

    // Recibe el formulario
    @PostMapping("/guardar")
    public String guardar(Asistencia asistencia,
            @RequestParam("idDocente") Long idDocente,
            Model model,
            RedirectAttributes redirectAttributes) {

        Docente docente = docenteRepository.findById(idDocente)
                .orElse(null);

        if (docente == null || !"Activo".equals(docente.getEstado())) {

            model.addAttribute("error",
                    "Debe seleccionar un docente activo.");

            asistencia.setDocente(null);
            cargarDocentesActivos(model);

            return "asistencia/formAsistencia";
        }

        if (asistencia.getIdAsistencia() == null) {

            if (asistenciaservice.existeAsistencia(
                    idDocente, asistencia.getFecha())) {

                model.addAttribute("error",
                        "El docente ya tiene una asistencia registrada en esa fecha.");

                asistencia.setDocente(docente);
                cargarDocentesActivos(model);

                return "asistencia/formAsistencia";
            }

        }

        asistencia.setDocente(docente);

        asistenciaservice.guardar(asistencia);

        redirectAttributes.addFlashAttribute("mensaje",
                "La asistencia se guardó correctamente.");

        return "redirect:/asistencias";
    }

    // Cargar docentes activos en el formulario
    private void cargarDocentesActivos(Model model) {

        List<Docente> docentes =
                docenteRepository.findByEstado("Activo");

        model.addAttribute("docentes", docentes);
    }

}


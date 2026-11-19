package ar.com.practica2026.ICS6030.serviceimplement;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.com.practica2026.ICS6030.entity.Docente;
import ar.com.practica2026.ICS6030.repository.DocenteRepository;
import ar.com.practica2026.ICS6030.service.DocenteService;

@Service
public class DocenteServiceImpl implements DocenteService {

	private final DocenteRepository docenteRepository;

	public DocenteServiceImpl(DocenteRepository docenteRepository) {
		this.docenteRepository = docenteRepository;
	}

	@Override
	public List<Docente> buscar(String texto) {

		// Sin texto: devolver todos los docentes
		if (texto == null || texto.isBlank()) {
			return docenteRepository.findAll();
		}

		texto = texto.trim();

		// Si contiene números, buscar por DNI
		if (texto.matches("[0-9]{1,8}")) {
			return docenteRepository.findByDni(Integer.parseInt(texto));
		}

		// Buscar por apellido o nombre
		return docenteRepository.findByApellidoContainingIgnoreCaseOrNombreContainingIgnoreCase(texto, texto);
	}

	@Override
	public List<Docente> listarActivos() {

		return docenteRepository.findByEstado("Activo");
	}

	@Override
	public Docente buscarPorId(Long id) {

		return docenteRepository.findById(id).orElse(null);
	}

	@Override
	public boolean existeOtroConDni(Docente docente) {

		for (Docente d : docenteRepository.findByDni(docente.getDni())) {

			// No contar al mismo docente cuando se edita
			if (!d.getIdDocente().equals(docente.getIdDocente())) {
				return true;
			}
		}

		return false;
	}

	@Override
	public void guardar(Docente docente) {

		docenteRepository.save(docente);
	}

	@Override
	public void cambiarEstado(Long id, String estado) {

		Docente docente = docenteRepository.findById(id).orElse(null);

		if (docente != null) {

			docente.setEstado(estado);

			docenteRepository.save(docente);
		}
	}
}